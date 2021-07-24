package co.programacionmaster.hambrecero.webservice.model;

import co.programacionmaster.hambrecero.businessapi.model.File;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileResource implements File {

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
   * @return A new {@link FileResource} instance
   */
  @Nonnull
  public static FileResource from(
      @Nonnull File other
  ) {
    return new FileResource(
        other.getId(),
        other.getTitle(),
        other.getUrl(),
        other.getRecordId(),
        other.getCreatedOn(),
        other.getCreatedBy()
    );
  }
}
