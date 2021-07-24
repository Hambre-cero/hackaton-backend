package co.programacionmaster.hambrecero.webservice.model;

import co.programacionmaster.hambrecero.businessapi.enums.DonationStatus;
import co.programacionmaster.hambrecero.businessapi.model.Donation;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DonationResource implements Donation {

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
   * @return A new {@link DonationResource} instance
   */
  @Nonnull
  public static DonationResource from(
      @Nonnull Donation other
  ) {
    return new DonationResource(
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