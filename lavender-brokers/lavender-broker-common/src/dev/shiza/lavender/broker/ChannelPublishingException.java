package dev.shiza.lavender.broker;

public final class ChannelPublishingException extends IllegalStateException {

  public ChannelPublishingException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ChannelPublishingException(final String message) {
    super(message);
  }
}
