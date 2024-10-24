package dev.shiza.lavender.codec;

/** An exception, which is called when an exception occurs during packet encoding. */
public final class PacketEncodingException extends IllegalStateException {

  public PacketEncodingException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public PacketEncodingException(final String message) {
    super(message);
  }
}
