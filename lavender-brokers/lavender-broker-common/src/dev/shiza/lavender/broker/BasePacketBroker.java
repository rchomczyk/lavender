package dev.shiza.lavender.broker;

import dev.shiza.lavender.codec.Packet;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public abstract class BasePacketBroker<T> implements PacketBroker<T> {

  @Override
  public void delegateToPacketBroker(final Packet request, final Packet response)
      throws PacketOrchestrationException {
    if (request.getTarget() == null) {
      throw new PacketOrchestrationException(
          "Could not delegate packet to packet broker due to missing target.");
    }

    publish(request.getTarget(), response);
  }
}
