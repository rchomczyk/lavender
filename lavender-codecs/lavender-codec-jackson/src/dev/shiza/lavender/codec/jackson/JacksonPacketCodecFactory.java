package dev.shiza.lavender.codec.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dev.shiza.lavender.codec.PacketCodec;

public final class JacksonPacketCodecFactory {

  private JacksonPacketCodecFactory() {}

  public static PacketCodec create(final ObjectMapper objectMapper) {
    return new JacksonPacketCodec(objectMapper);
  }

  public static PacketCodec create() {
    final ObjectMapper self = new ObjectMapper();
    self.setVisibility(
        self.getSerializationConfig()
            .getDefaultVisibilityChecker()
            .withFieldVisibility(Visibility.ANY)
            .withGetterVisibility(Visibility.NONE)
            .withSetterVisibility(Visibility.NONE)
            .withCreatorVisibility(Visibility.NONE));
    self.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    self.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    self.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
    self.registerSubtypes(JacksonPacket.class);
    return create(self);
  }
}
