package dev.shiza.lavender.broker;

/** An exception that is thrown when a channel publishing operation fails. */
public final class ChannelPublishingException extends IllegalStateException {

  public ChannelPublishingException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
