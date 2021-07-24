package co.programacionmaster.hambrecero.businessapi.values;

import co.programacionmaster.hambrecero.businessapi.enums.DonationStatus;
import co.programacionmaster.hambrecero.businessapi.model.Donation;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class DonationValue implements Donation {

  @Nonnull
  private String id;

  @Nonnull
  private String donorId;

  @Nonnull
  private String announceId;

  @Nullable
  private String note;

  @Nonnull
  private DonationStatus status;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Static factory method.
   *
   * @param other Other {@link Donation}
   * @return A new {@link DonationValue} instance
   */
  @Nonnull
  public static DonationValue from(
      @Nonnull Donation other
  ) {
    return new DonationValue(
        other.getId(),
        other.getDonorId(),
        other.getAnnounceId(),
        other.getNote().getOrNull(),
        other.getStatus(),
        other.getCreatedOn(),
        other.getCreatedBy()
    );
  }

  @Nonnull
  @Override
  public Option<String> getNote() {
    return Option.of(note);
  }
}
