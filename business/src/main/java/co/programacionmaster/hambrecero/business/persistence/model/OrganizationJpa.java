package co.programacionmaster.hambrecero.business.persistence.model;

import co.programacionmaster.hambrecero.businessapi.enums.OrganizationStatus;
import co.programacionmaster.hambrecero.businessapi.model.Organization;
import co.programacionmaster.hambrecero.businessapi.values.OrganizationValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "organizations")
public class OrganizationJpa implements Organization {

  @Id
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
  @Enumerated(EnumType.STRING)
  private OrganizationStatus status;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Private default constructor for JPA.
   */
  @SuppressFBWarnings("NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
  private OrganizationJpa() {
  }

  /**
   * Static factory method.
   *
   * @param other Other {@link Organization}
   * @return A new {@link OrganizationJpa} instance
   */
  @Nonnull
  public static OrganizationJpa from(
      @Nonnull Organization other
  ) {
    return new OrganizationJpa(
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

  public Organization narrow() {
    return OrganizationValue.from(this);
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