package dev.shiza.lavender.broker;

public final class ChannelObservingException extends IllegalStateException {

  public ChannelObservingException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ChannelObservingException(final String message) {
    super(message);
  }
}
