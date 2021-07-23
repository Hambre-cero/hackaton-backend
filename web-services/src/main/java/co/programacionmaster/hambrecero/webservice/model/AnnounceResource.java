package co.programacionmaster.hambrecero.webservice.model;

import co.programacionmaster.hambrecero.businessapi.enums.AnnounceStatus;
import co.programacionmaster.hambrecero.businessapi.model.Announce;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnnounceResource implements Announce {

  @Nonnull
  private String id;

  @Nonnull
  private String name;

  @Nonnull
  private String description;

  @Nonnull
  private String organizationId;

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
   * @return A new {@link AnnounceResource} instance
   */
  @Nonnull
  public static AnnounceResource from(
      @Nonnull Announce other
  ) {
    return new AnnounceResource(
        other.getId(),
        other.getName(),
        other.getDescription(),
        other.getOrganizationId(),
        other.getStatus(),
        other.getCreatedOn(),
        other.getCreatedBy()
    );
  }
}
