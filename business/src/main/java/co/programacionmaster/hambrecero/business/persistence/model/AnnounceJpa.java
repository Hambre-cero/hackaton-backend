package co.programacionmaster.hambrecero.business.persistence.model;

import co.programacionmaster.hambrecero.businessapi.enums.AnnounceStatus;
import co.programacionmaster.hambrecero.businessapi.model.Announce;
import co.programacionmaster.hambrecero.businessapi.values.AnnounceValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
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
@Table(name = "announces")
public class AnnounceJpa implements Announce {

  @Id
  @Nonnull
  private String id;

  @Nonnull
  private String title;

  @Nonnull
  private String description;

  @Nonnull
  @Enumerated(EnumType.STRING)
  private AnnounceStatus status;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Private default constructor for JPA.
   */
  @SuppressFBWarnings("NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
  private AnnounceJpa() {
  }

  public Announce narrow() {
    return AnnounceValue.from(this);
  }

  /**
   * Static factory method.
   *
   * @param other Other {@link Announce}
   * @return A new {@link AnnounceJpa} instance
   */
  @Nonnull
  public static AnnounceJpa from(
      @Nonnull Announce other
  ) {
    return new AnnounceJpa(
        other.getId(),
        other.getTitle(),
        other.getDescription(),
        other.getStatus(),
        other.getCreatedOn(),
        other.getCreatedBy()
    );
  }
}
