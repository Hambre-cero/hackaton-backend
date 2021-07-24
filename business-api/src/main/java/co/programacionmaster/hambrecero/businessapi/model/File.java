package co.programacionmaster.hambrecero.businessapi.model;

import java.time.LocalDateTime;
import javax.annotation.Nonnull;

public interface File {

  @Nonnull
  String getId();

  @Nonnull
  String getTitle();

  @Nonnull
  String getUrl();

  @Nonnull
  String getRecordId();

  @Nonnull
  LocalDateTime getCreatedOn();

  @Nonnull
  String getCreatedBy();
}
