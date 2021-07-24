package co.programacionmaster.hambrecero.businessapi.model;

import co.programacionmaster.hambrecero.businessapi.enums.DonationStatus;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;

public interface Donation {

  @Nonnull
  String getId();

  @Nonnull
  String getDonorId();

  @Nonnull
  String getAnnounceId();

  @Nonnull
  Option<String> getNote();

  @Nonnull
  DonationStatus getStatus();

  @Nonnull
  LocalDateTime getCreatedOn();

  @Nonnull
  String getCreatedBy();
}
