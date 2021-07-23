package co.programacionmaster.hambrecero.webservice.model;

import co.programacionmaster.hambrecero.businessapi.enums.OrganizationStatus;
import co.programacionmaster.hambrecero.businessapi.model.Organization;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrganizationDraftResource implements Organization {

  @Nullable
  private String id;

  @NotBlank
  private String identification;

  @NotBlank
  private String name;

  @NotBlank
  private String country;

  @NotBlank
  private String city;

  @NotBlank
  private String province;

  @NotBlank
  private String address;

  @Nullable
  private String postalCode;

  @NotBlank
  private String phoneNumber;

  @Nullable
  private String secondaryPhoneNumber;

  @Nullable
  private OrganizationStatus status;

  @Nullable
  private LocalDateTime createdOn;

  @Nullable
  private String createdBy;

  @Nonnull
  @Override
  public Option<String> getPostalCode() {
    return Option.of(postalCode);
  }

  @Nonnull
  @Override
  public Option<String> getSecondaryPhoneNumber() {
    return Option.of(secondaryPhoneNumber);
  }
}
