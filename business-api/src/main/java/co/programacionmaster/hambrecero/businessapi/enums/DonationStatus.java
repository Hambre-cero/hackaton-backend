package co.programacionmaster.hambrecero.businessapi.enums;

public enum DonationStatus {
  ACTIVE("ACTIVE"),
  INACTIVE("INACTIVE");

  private String value;

  DonationStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
