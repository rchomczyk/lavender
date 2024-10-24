package dev.shiza.lavender.codec.jackson;

import dev.shiza.lavender.codec.Packet;
import dev.shiza.lavender.codec.PacketCodec;

final class JacksonPacketCodecTestBase {

  static final PacketCodec CODEC = JacksonPacketCodecFactory.create();

  static final Packet EMPTY_PACKET = new TestPacket();
  static final Packet NON_EMPTY_PACKET = new TestPacket("John", "Smith");

  private JacksonPacketCodecTestBase() {}
}
