package dev.shiza.lavender.broker;

import dev.shiza.dew.subscription.Subscriber;
import dev.shiza.lavender.codec.Packet;
import java.io.Closeable;
import java.util.concurrent.CompletableFuture;

public interface PacketBroker<T> extends PacketOrchestrator<T>, Closeable {

  /**
   * Observes a channel for incoming packets.
   *
   * @param subscriber subscriber
   * @throws ChannelObservingException if channel could not be observed
   */
  void observe(final Subscriber subscriber) throws ChannelObservingException;

  /**
   * Publishes a packet to specified channel.
   *
   * @param channel channel to publish packet to
   * @param packet packet to be published
   * @throws ChannelPublishingException if packet could not be published
   */
  void publish(final String channel, final Packet packet) throws ChannelPublishingException;

  /**
   * Requests a packet from specified channel. Firstly, it sends a specified packet as a request,
   * and awaits for the response packet from the channel.
   *
   * @param channel channel to request packet from
   * @param packet packet to be sent as a request
   * @return response packet
   * @param <R> generic type of response packet
   */
  <R extends Packet> CompletableFuture<R> request(final String channel, final Packet packet);
}
