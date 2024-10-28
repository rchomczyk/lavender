package dev.shiza.lavender.broker;

import dev.shiza.lavender.codec.Packet;

public interface PacketOrchestrator<T> {

  /**
   * Delegates packet to event bus.
   *
   * @param message message to be delegated
   * @throws PacketOrchestrationException if packet could not be delegated to event bus
   */
  void delegateToEventBus(final T message) throws PacketOrchestrationException;

  /**
   * Delegates packet to packet broker.
   *
   * @param request packet sent as a request
   * @param response packet to be sent as a response
   * @throws PacketOrchestrationException if packet could not be delegated to packet broker
   */
  void delegateToPacketBroker(final Packet request, final Packet response)
      throws PacketOrchestrationException;
}
