package co.programacionmaster.hambrecero.businessapi.model;

import co.programacionmaster.hambrecero.businessapi.enums.AnnounceStatus;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;

public interface Announce {

  @Nonnull
  String getId();

  @Nonnull
  String getTitle();

  @Nonnull
  String getDescription();

  @Nonnull
  AnnounceStatus getStatus();

  @Nonnull
  LocalDateTime getCreatedOn();

  @Nonnull
  String getCreatedBy();
}
