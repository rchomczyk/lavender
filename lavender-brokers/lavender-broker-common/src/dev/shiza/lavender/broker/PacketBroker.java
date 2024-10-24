package dev.shiza.lavender.broker;

import dev.shiza.lavender.codec.Packet;
import java.util.concurrent.CompletableFuture;

public interface PacketBroker {

  void observe(final String channel) throws ChannelObservingException;

  void publish(final String channel, final Packet packet) throws ChannelPublishingException;

  CompletableFuture<Void> publishAsync(final String channel, final Packet packet);
}
