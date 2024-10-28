package dev.shiza.lavender.broker.nats;

import dev.shiza.lavender.broker.PacketBroker;
import io.nats.client.Message;

/** A packet broker that uses NATS as the underlying transport. */
public interface NatsPacketBroker extends PacketBroker<Message> {}
