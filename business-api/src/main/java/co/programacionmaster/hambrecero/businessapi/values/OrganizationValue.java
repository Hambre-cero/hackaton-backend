package co.programacionmaster.hambrecero.businessapi.values;

import co.programacionmaster.hambrecero.businessapi.enums.OrganizationStatus;
import co.programacionmaster.hambrecero.businessapi.model.Organization;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class OrganizationValue implements Organization {

  @Nonnull
  private String id;

  @Nonnull
  private String identification;

  @Nonnull
  private String name;

  @Nonnull
  private String country;

  @Nonnull
  private String city;

  @Nonnull
  private String province;

  @Nonnull
  private String address;

  @Nullable
  private String postalCode;

  @Nonnull
  private String phoneNumber;

  @Nullable
  private String secondaryPhoneNumber;

  @Nonnull
  private OrganizationStatus status;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Static factory method.
   *
   * @param other Other {@link Organization}
   * @return A new {@link OrganizationValue} instance
   */
  @Nonnull
  public static OrganizationValue from(
      @Nonnull Organization other
  ) {
    return new OrganizationValue(
        other.getId(),
        other.getIdentification(),
        other.getName(),
        other.getCountry(),
        other.getCity(),
        other.getProvince(),
        other.getAddress(),
        other.getPostalCode().getOrNull(),
        other.getPhoneNumber(),
        other.getSecondaryPhoneNumber().getOrNull(),
        other.getStatus(),
        other.getCreatedOn(),
        other.getCreatedBy()
    );
  }

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
