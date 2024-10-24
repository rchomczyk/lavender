package dev.shiza.lavender.codec.jackson;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

final class JacksonPacketEncoderTests {

  @Test
  void encodingNonEmptyPacketShouldSucceed() {
    assertThat(
            JacksonPacketCodecTestBase.CODEC
                .encoder()
                .encode(JacksonPacketCodecTestBase.NON_EMPTY_PACKET))
        .isNotEmpty();
  }

  @Test
  void encodingEmptyPacketShouldSucceed() {
    assertThat(
            JacksonPacketCodecTestBase.CODEC
                .encoder()
                .encode(JacksonPacketCodecTestBase.EMPTY_PACKET))
        .isNotEmpty();
  }
}
