package co.programacionmaster.hambrecero.businessapi.enums;

public enum OrganizationStatus {
  ACTIVE("ACTIVE"),
  INACTIVE("INACTIVE");

  private String value;

  OrganizationStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}