package co.programacionmaster.hambrecero.iamapi.model.enums;

public enum UserStatus {
  ACTIVE("ACTIVE"),
  INACTIVE("INACTIVE");

  private String value;

  UserStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
