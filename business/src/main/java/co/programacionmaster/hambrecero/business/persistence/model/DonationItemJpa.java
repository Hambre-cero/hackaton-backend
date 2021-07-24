package co.programacionmaster.hambrecero.business.persistence.model;

import co.programacionmaster.hambrecero.businessapi.enums.DonationItemStatus;
import co.programacionmaster.hambrecero.businessapi.model.DonationItem;
import co.programacionmaster.hambrecero.businessapi.model.DonationItem;
import co.programacionmaster.hambrecero.businessapi.values.DonationItemValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.vavr.control.Option;
import java.time.LocalDate;
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
@Table(name = "donation_items")
public class DonationItemJpa implements DonationItem {

  @Id
  @Nonnull
  private String id;

  @Nonnull
  private String title;

  @Nonnull
  private String description;

  @Nonnull
  private String unit;

  @Nonnull
  private Float quantity;

  @Nullable
  private LocalDate expirationDate;

  @Nonnull
  private String donationId;

  @Nonnull
  @Enumerated(EnumType.STRING)
  private DonationItemStatus status;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Private default constructor for JPA.
   */
  @SuppressFBWarnings("NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
  private DonationItemJpa() {
  }

  public DonationItem narrow() {
    return DonationItemValue.from(this);
  }

  /**
   * Static factory method.
   *
   * @param other Other {@link DonationItem}
   * @return A new {@link DonationItemJpa} instance
   */
  @Nonnull
  public static DonationItemJpa from(
      @Nonnull DonationItem other
  ) {
    return new DonationItemJpa(
        other.getId(),
        other.getTitle(),
        other.getDescription(),
        other.getUnit(),
        other.getQuantity(),
        other.getExpirationDate().getOrNull(),
        other.getDonationId(),
        other.getStatus(),
        other.getCreatedOn(),
        other.getCreatedBy()
    );
  }

  @Nonnull
  @Override
  public Option<LocalDate> getExpirationDate() {
    return Option.of(expirationDate);
  }
}
