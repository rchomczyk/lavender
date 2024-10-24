package dev.shiza.lavender.codec.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.shiza.lavender.codec.Packet;
import dev.shiza.lavender.codec.PacketEncoder;
import dev.shiza.lavender.codec.PacketEncodingException;
import org.jetbrains.annotations.NotNull;

final class JacksonPacketEncoder implements PacketEncoder {

  private final ObjectMapper objectMapper;

  JacksonPacketEncoder(final ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public <T extends Packet> byte @NotNull [] encode(final T packet) {
    try {
      return objectMapper.writeValueAsBytes(packet);
    } catch (final JsonProcessingException exception) {
      throw new PacketEncodingException(
          "Could not encode packet into binary payload, because of unexpected exception.",
          exception);
    }
  }
}
