package co.programacionmaster.hambrecero.businessapi.values;

import co.programacionmaster.hambrecero.businessapi.enums.AnnounceStatus;
import co.programacionmaster.hambrecero.businessapi.model.Announce;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class AnnounceValue implements Announce {

  @Nonnull
  private String id;

  @Nonnull
  private String title;

  @Nonnull
  private String description;

  @Nonnull
  private AnnounceStatus status;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Static factory method.
   *
   * @param other Other {@link Announce}
   * @return A new {@link AnnounceValue} instance
   */
  @Nonnull
  public static AnnounceValue from(
      @Nonnull Announce other
  ) {
    return new AnnounceValue(
        other.getId(),
        other.getTitle(),
        other.getDescription(),
        other.getStatus(),
        other.getCreatedOn(),
        other.getCreatedBy()
    );
  }
}