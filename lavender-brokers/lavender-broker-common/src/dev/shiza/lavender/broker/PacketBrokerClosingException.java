package dev.shiza.lavender.broker;

/** An exception that is thrown when a packet broker could not be closed. */
public class PacketBrokerClosingException extends IllegalStateException {

  public PacketBrokerClosingException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
