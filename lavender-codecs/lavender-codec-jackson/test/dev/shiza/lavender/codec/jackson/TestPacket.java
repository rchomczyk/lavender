package dev.shiza.lavender.codec.jackson;

import java.util.Objects;

final class TestPacket extends JacksonPacket {

  private String name;
  private String surname;

  public TestPacket(final String name, final String surname) {
    this.name = name;
    this.surname = surname;
  }

  public TestPacket() {}

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final TestPacket that = (TestPacket) o;
    return Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname);
  }
}
