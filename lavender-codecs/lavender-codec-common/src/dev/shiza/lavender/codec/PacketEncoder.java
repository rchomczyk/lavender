package dev.shiza.lavender.codec;

import org.jetbrains.annotations.NotNull;

public interface PacketEncoder {

  /**
   * Encodes packet into binary payload.
   *
   * @param packet packet to be encoded
   * @return encoded packet as binary payload
   * @param <T> generic type of packet
   */
  <T extends Packet> byte @NotNull [] encode(final T packet);
}
