package dev.shiza.lavender.broker.nats;

import dev.shiza.dew.event.EventBus;
import dev.shiza.dew.event.EventBusFactory;
import dev.shiza.lavender.codec.PacketCodec;
import io.nats.client.Connection;
import java.time.Duration;

public final class NatsPacketBrokerBuilder {

  private final PacketCodec packetCodec;
  private final Connection connection;
  private String identifier = String.valueOf(ProcessHandle.current().pid());
  private EventBus eventBus = EventBusFactory.create();
  private Duration requestTtl = Duration.ofSeconds(2);

  private NatsPacketBrokerBuilder(final PacketCodec packetCodec, final Connection connection) {
    this.packetCodec = packetCodec;
    this.connection = connection;
  }

  public static NatsPacketBrokerBuilder builder(
      final PacketCodec packetCodec, final Connection connection) {
    return new NatsPacketBrokerBuilder(packetCodec, connection);
  }

  public NatsPacketBrokerBuilder identifier(final String identifier) {
    this.identifier = identifier;
    return this;
  }

  public NatsPacketBrokerBuilder eventBus(final EventBus eventBus) {
    this.eventBus = eventBus;
    return this;
  }

  public NatsPacketBrokerBuilder requestTtl(final Duration requestTtl) {
    this.requestTtl = requestTtl;
    return this;
  }

  public NatsPacketBroker build() {
    return new NatsPacketBrokerImpl(identifier, packetCodec, eventBus, requestTtl, connection);
  }
}
