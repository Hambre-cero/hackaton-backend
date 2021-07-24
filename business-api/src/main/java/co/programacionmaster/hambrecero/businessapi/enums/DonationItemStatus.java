package co.programacionmaster.hambrecero.businessapi.enums;

public enum DonationItemStatus {
  ACTIVE("ACTIVE"),
  INACTIVE("INACTIVE");

  private String value;

  DonationItemStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
