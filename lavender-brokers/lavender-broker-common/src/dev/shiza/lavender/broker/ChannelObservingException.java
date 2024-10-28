package dev.shiza.lavender.broker;

/** An exception that is thrown when a channel observing operation fails. */
public final class ChannelObservingException extends IllegalStateException {

  public ChannelObservingException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
