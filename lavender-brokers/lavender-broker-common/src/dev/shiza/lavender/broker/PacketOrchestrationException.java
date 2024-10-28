package dev.shiza.lavender.broker;

/** An exception that is thrown when a packet orchestration operation fails. */
public final class PacketOrchestrationException extends IllegalStateException {

  public PacketOrchestrationException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public PacketOrchestrationException(final String message) {
    super(message);
  }
}
