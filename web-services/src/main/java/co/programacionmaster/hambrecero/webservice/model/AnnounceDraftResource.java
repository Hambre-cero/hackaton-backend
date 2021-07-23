package co.programacionmaster.hambrecero.webservice.model;

import co.programacionmaster.hambrecero.businessapi.enums.AnnounceStatus;
import co.programacionmaster.hambrecero.businessapi.model.Announce;
import java.time.LocalDateTime;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AnnounceDraftResource implements Announce {

  @Nullable
  private String id;

  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @NotBlank
  private String organizationId;

  @Nullable
  private AnnounceStatus status;

  @Nullable
  private LocalDateTime createdOn;

  @Nullable
  private String createdBy;
}
