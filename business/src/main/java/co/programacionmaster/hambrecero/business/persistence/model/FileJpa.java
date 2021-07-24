package co.programacionmaster.hambrecero.business.persistence.model;

import co.programacionmaster.hambrecero.businessapi.model.File;
import co.programacionmaster.hambrecero.businessapi.values.FileValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "files")
public class FileJpa implements File {

  @Id
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
   * Private default constructor for JPA.
   */
  @SuppressFBWarnings("NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
  private FileJpa() {
  }

  public File narrow() {
    return FileValue.from(this);
  }

  /**
   * Static factory method.
   *
   * @param other Other {@link File}
   * @return A new {@link FileJpa} instance
   */
  @Nonnull
  public static FileJpa from(
      @Nonnull File other
  ) {
    return new FileJpa(
        other.getId(),
        other.getTitle(),
        other.getUrl(),
        other.getRecordId(),
        other.getCreatedOn(),
        other.getCreatedBy()
    );
  }
}
