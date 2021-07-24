package co.programacionmaster.hambrecero.businessapi.model;

import co.programacionmaster.hambrecero.businessapi.enums.DonationItemStatus;
import io.vavr.control.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;

public interface DonationItem {

  @Nonnull
  String getId();

  @Nonnull
  String getTitle();

  @Nonnull
  String getDescription();

  @Nonnull
  String getUnit();

  @Nonnull
  Float getQuantity();

  @Nonnull
  Option<LocalDate> getExpirationDate();

  @Nonnull
  String getDonationId();

  @Nonnull
  DonationItemStatus getStatus();

  @Nonnull
  LocalDateTime getCreatedOn();

  @Nonnull
  String getCreatedBy();
}
