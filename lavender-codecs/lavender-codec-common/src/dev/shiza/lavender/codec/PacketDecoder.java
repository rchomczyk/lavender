package dev.shiza.lavender.codec;

import org.jetbrains.annotations.NotNull;

public interface PacketDecoder {

  /**
   * Decodes payload into packet.
   *
   * @param payload binary payload to be decoded
   * @return decoded packet
   * @param <T> generic type of packet
   */
  <T extends Packet> T decode(final byte @NotNull [] payload);
}
