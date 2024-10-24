package dev.shiza.lavender.codec.jackson;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

final class JacksonPacketDecoderTests {

  @Test
  void decodingNonEmptyPacketShouldSucceed() {
    assertThat(
            (TestPacket)
                JacksonPacketCodecTestBase.CODEC
                    .decoder()
                    .decode(
                        new byte[] {
                          123, 34, 116, 121, 112, 101, 34, 58, 34, 100, 101, 118, 46, 115, 104, 105,
                          122, 97, 46, 108, 97, 118, 101, 110, 100, 101, 114, 46, 99, 111, 100, 101,
                          99, 46, 106, 97, 99, 107, 115, 111, 110, 46, 84, 101, 115, 116, 80, 97,
                          99, 107, 101, 116, 34, 44, 34, 110, 97, 109, 101, 34, 58, 34, 74, 111,
                          104, 110, 34, 44, 34, 115, 117, 114, 110, 97, 109, 101, 34, 58, 34, 83,
                          109, 105, 116, 104, 34, 125
                        }))
        .isEqualTo(JacksonPacketCodecTestBase.NON_EMPTY_PACKET);
  }

  @Test
  void decodingEmptyPacketShouldSucceed() {
    assertThat(
            (TestPacket)
                JacksonPacketCodecTestBase.CODEC
                    .decoder()
                    .decode(
                        new byte[] {
                          123, 34, 116, 121, 112, 101, 34, 58, 34, 100, 101, 118, 46, 115, 104, 105,
                          122, 97, 46, 108, 97, 118, 101, 110, 100, 101, 114, 46, 99, 111, 100, 101,
                          99, 46, 106, 97, 99, 107, 115, 111, 110, 46, 84, 101, 115, 116, 80, 97,
                          99, 107, 101, 116, 34, 44, 34, 110, 97, 109, 101, 34, 58, 110, 117, 108,
                          108, 44, 34, 115, 117, 114, 110, 97, 109, 101, 34, 58, 110, 117, 108, 108,
                          125
                        }))
        .isEqualTo(JacksonPacketCodecTestBase.EMPTY_PACKET);
  }
}
