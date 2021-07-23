package co.programacionmaster.hambrecero.businessapi.enums;

public enum AnnounceStatus {
  ACTIVE("ACTIVE"),
  INACTIVE("INACTIVE");

  private String value;

  AnnounceStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
