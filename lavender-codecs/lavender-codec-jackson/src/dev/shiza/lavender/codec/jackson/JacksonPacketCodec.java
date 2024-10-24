package dev.shiza.lavender.codec.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.shiza.lavender.codec.PacketCodec;
import dev.shiza.lavender.codec.PacketDecoder;
import dev.shiza.lavender.codec.PacketEncoder;

final class JacksonPacketCodec implements PacketCodec {

  private final PacketEncoder encoder;
  private final PacketDecoder decoder;

  JacksonPacketCodec(final ObjectMapper objectMapper) {
    this.encoder = new JacksonPacketEncoder(objectMapper);
    this.decoder = new JacksonPacketDecoder(objectMapper);
  }

  @Override
  public PacketEncoder encoder() {
    return encoder;
  }

  @Override
  public PacketDecoder decoder() {
    return decoder;
  }
}
