package co.programacionmaster.hambrecero.businessapi.values;

import co.programacionmaster.hambrecero.businessapi.model.File;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class FileValue implements File {

  @Nonnull
  private String id;

  @Nonnull
  private String title;

  @Nonnull
  private String url;

  @Nonnull
  private String recordId;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Static factory method.
   *
   * @param other Other {@link File}
   * @return A new {@link FileValue} instance
   */
  @Nonnull
  public static FileValue from(
      @Nonnull File other
  ) {
    return new FileValue(
        other.getId(),
        other.getTitle(),
        other.getUrl(),
        other.getRecordId(),
        other.getCreatedOn(),
        other.getCreatedBy()
    );
  }
}
