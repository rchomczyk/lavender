package dev.shiza.lavender.codec;

import dev.shiza.dew.event.Event;
import java.io.Serializable;

public abstract class Packet implements Event, Serializable {

  private String source;
  private String target;

  protected Packet() {}

  public String getSource() {
    return source;
  }

  public void setSource(final String source) {
    this.source = source;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(final String target) {
    this.target = target;
  }
}
