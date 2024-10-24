package dev.shiza.lavender.codec;

/** An exception, which is called when an exception occurs during packet decoding. */
public final class PacketDecodingException extends IllegalStateException {

  public PacketDecodingException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public PacketDecodingException(final String message) {
    super(message);
  }
}
