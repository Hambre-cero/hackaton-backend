package co.programacionmaster.hambrecero.business.persistence.model;

import co.programacionmaster.hambrecero.businessapi.enums.DonationStatus;
import co.programacionmaster.hambrecero.businessapi.model.Donation;
import co.programacionmaster.hambrecero.businessapi.values.DonationValue;
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
@Table(name = "donations")
public class DonationJpa implements Donation {

  @Id
  @Nonnull
  private String id;

  @Nonnull
  private String donorId;

  @Nonnull
  private String announceId;

  @Nullable
  private String note;

  @Nonnull
  @Enumerated(EnumType.STRING)
  private DonationStatus status;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Private default constructor for JPA.
   */
  @SuppressFBWarnings("NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
  private DonationJpa() {
  }

  public Donation narrow() {
    return DonationValue.from(this);
  }

  /**
   * Static factory method.
   *
   * @param other Other {@link Donation}
   * @return A new {@link DonationJpa} instance
   */
  @Nonnull
  public static DonationJpa from(
      @Nonnull Donation other
  ) {
    return new DonationJpa(
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