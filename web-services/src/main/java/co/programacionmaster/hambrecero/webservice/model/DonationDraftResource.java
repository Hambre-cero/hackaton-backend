package co.programacionmaster.hambrecero.webservice.model;

import co.programacionmaster.hambrecero.businessapi.enums.DonationStatus;
import co.programacionmaster.hambrecero.businessapi.model.Donation;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DonationDraftResource implements Donation {

  @Nullable
  private String id;

  @NotBlank
  private String donorId;

  @NotBlank
  private String announceId;

  @Nullable
  private String note;

  @Nullable
  private DonationStatus status;

  @Nullable
  private LocalDateTime createdOn;

  @Nullable
  private String createdBy;

  @Nonnull
  @Override
  public Option<String> getNote() {
    return Option.of(note);
  }
}
