package dev.shiza.lavender.broker;

import dev.shiza.lavender.codec.Packet;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface PacketOrchestrator<T> {

  /**
   * Delegates packet to event bus.
   *
   * @return consumer for packet delegation
   * @throws PacketOrchestrationException if packet could not be delegated to event bus
   */
  Consumer<T> delegateToEventBus() throws PacketOrchestrationException;

  /**
   * Delegates packet to packet broker.
   *
   * @return consumer for packet delegation
   * @throws PacketOrchestrationException if packet could not be delegated to packet broker
   */
  BiConsumer<Packet, Packet> delegateToPacketBroker() throws PacketOrchestrationException;
}
