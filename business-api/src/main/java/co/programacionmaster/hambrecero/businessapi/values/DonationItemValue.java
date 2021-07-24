package co.programacionmaster.hambrecero.businessapi.values;

import co.programacionmaster.hambrecero.businessapi.enums.DonationItemStatus;
import co.programacionmaster.hambrecero.businessapi.model.DonationItem;
import io.vavr.control.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class DonationItemValue implements DonationItem {

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
  private DonationItemStatus status;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Static factory method.
   *
   * @param other Other {@link DonationItem}
   * @return A new {@link DonationItemValue} instance
   */
  @Nonnull
  public static DonationItemValue from(
      @Nonnull DonationItem other
  ) {
    return new DonationItemValue(
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
