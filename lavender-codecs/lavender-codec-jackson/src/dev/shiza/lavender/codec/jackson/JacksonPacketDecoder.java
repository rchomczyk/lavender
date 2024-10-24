package dev.shiza.lavender.codec.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.shiza.lavender.codec.Packet;
import dev.shiza.lavender.codec.PacketDecoder;
import dev.shiza.lavender.codec.PacketDecodingException;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

final class JacksonPacketDecoder implements PacketDecoder {

  private final ObjectMapper objectMapper;

  JacksonPacketDecoder(final ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public <T extends Packet> T decode(final byte @NotNull [] payload)
      throws PacketDecodingException {
    try {
      // noinspection unchecked
      return (T) objectMapper.readValue(payload, JacksonPacket.class);
    } catch (final IOException exception) {
      throw new PacketDecodingException(
          "Could not decode binary payload into packet, because of unexpected exception.",
          exception);
    }
  }
}
