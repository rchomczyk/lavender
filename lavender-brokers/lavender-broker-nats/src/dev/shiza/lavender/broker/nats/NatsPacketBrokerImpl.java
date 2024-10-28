package dev.shiza.lavender.broker.nats;

import dev.shiza.dew.event.EventBus;
import dev.shiza.dew.event.EventPublishingException;
import dev.shiza.dew.subscription.Subscriber;
import dev.shiza.dew.subscription.SubscribingException;
import dev.shiza.lavender.broker.BasePacketBroker;
import dev.shiza.lavender.broker.ChannelObservingException;
import dev.shiza.lavender.broker.ChannelPublishingException;
import dev.shiza.lavender.broker.PacketBrokerClosingException;
import dev.shiza.lavender.broker.PacketOrchestrationException;
import dev.shiza.lavender.codec.Packet;
import dev.shiza.lavender.codec.PacketCodec;
import io.nats.client.Connection;
import io.nats.client.Message;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

final class NatsPacketBrokerImpl extends BasePacketBroker<Message> implements NatsPacketBroker {

  private final String identity;
  private final PacketCodec packetCodec;
  private final EventBus eventBus;
  private final Duration requestTtl;
  private final Connection connection;

  NatsPacketBrokerImpl(
      final String identity,
      final PacketCodec packetCodec,
      final EventBus eventBus,
      final Duration requestTtl,
      final Connection connection) {
    this.identity = identity;
    this.packetCodec = packetCodec;
    this.eventBus = eventBus;
    this.eventBus.publisher(Runnable::run);
    this.eventBus.result(Packet.class, this::delegateToPacketBroker);
    this.requestTtl = requestTtl;
    this.connection = connection;
  }

  @Override
  public void observe(final Subscriber subscriber) throws ChannelObservingException {
    observeEventBus(subscriber);
    observePacketBroker(subscriber);
  }

  @Override
  public void publish(final String channel, final Packet packet) throws ChannelPublishingException {
    setPacketData(packet);
    try {
      connection.publish(channel, packetCodec.encoder().encode(packet));
    } catch (final IllegalStateException exception) {
      throw new ChannelPublishingException(
          "Could not publish packet on channel named %s due to unexpected exception."
              .formatted(channel),
          exception);
    }
  }

  @Override
  public <T extends Packet> CompletableFuture<T> request(
      final String channel, final Packet packet) {
    setPacketData(packet);
    return connection
        .requestWithTimeout(channel, packetCodec.encoder().encode(packet), requestTtl)
        .thenApply(Message::getData)
        .thenApply(packetCodec.decoder()::decode);
  }

  @Override
  public void delegateToEventBus(final Message message) throws PacketOrchestrationException {
    final Packet packet = packetCodec.decoder().decode(message.getData());
    if (packet.getSource().equals(identity)) {
      return;
    }

    if (message.getReplyTo() != null) {
      packet.setTarget(message.getReplyTo());
    }

    try {
      eventBus.publish(packet, message.getSubject());
    } catch (final EventPublishingException exception) {
      throw new PacketOrchestrationException(
          "Could not delegate packet to event bus due to unexpected exception.", exception);
    }
  }

  @Override
  public void close() throws PacketBrokerClosingException {
    try {
      connection.close();
    } catch (final InterruptedException exception) {
      throw new PacketBrokerClosingException(
          "Could not close packet broker due to unexpected exception.", exception);
    }
  }

  private void observeEventBus(final Subscriber subscriber) {
    try {
      eventBus.subscribe(subscriber);
    } catch (final SubscribingException exception) {
      throw new ChannelObservingException(
          "Could not subscribe to events on channel named %s due to unexpected exception."
              .formatted(subscriber.identity()),
          exception);
    }
  }

  private void observePacketBroker(final Subscriber subscriber) {
    try {
      connection.createDispatcher(this::delegateToEventBus).subscribe(subscriber.identity());
    } catch (final IllegalStateException exception) {
      throw new ChannelObservingException(
          "Could not create dispatcher on channel named %s due to unexpected exception."
              .formatted(subscriber.identity()),
          exception);
    }
  }

  private void setPacketData(final Packet packet) {
    packet.setSource(identity);
  }
}
