package co.programacionmaster.hambrecero.businessapi.model;

import co.programacionmaster.hambrecero.businessapi.enums.OrganizationStatus;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;

public interface Organization {

  @Nonnull
  String getId();

  @Nonnull
  String getIdentification();

  @Nonnull
  String getName();

  @Nonnull
  String getCountry();

  @Nonnull
  String getCity();

  @Nonnull
  String getProvince();

  @Nonnull
  String getAddress();

  @Nonnull
  Option<String> getPostalCode();

  @Nonnull
  String getPhoneNumber();

  @Nonnull
  Option<String> getSecondaryPhoneNumber();

  @Nonnull
  OrganizationStatus getStatus();

  @Nonnull
  LocalDateTime getCreatedOn();

  @Nonnull
  String getCreatedBy();
}
