package dev.shiza.lavender.codec;

public interface PacketCodec {

  /**
   * Returns packet encoder.
   *
   * @return an packet encoder
   */
  PacketEncoder encoder();

  /**
   * Returns packet decoder.
   *
   * @return an packet decoder
   */
  PacketDecoder decoder();
}
