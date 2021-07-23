package co.programacionmaster.hambrecero.iamapi.model;

import co.programacionmaster.hambrecero.iamapi.model.enums.RoleId;
import co.programacionmaster.hambrecero.iamapi.model.enums.UserStatus;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;

public interface User {

  @Nonnull
  String getId();

  @Nonnull
  String getName();

  @Nonnull
  String getEmail();

  @Nonnull
  Option<String> getPassword();

  @Nonnull
  RoleId getRoleId();

  @Nonnull
  Option<String> getOrganizationId();

  @Nonnull
  UserStatus getStatus();

  @Nonnull
  LocalDateTime getCreatedOn();

  @Nonnull
  String getCreatedBy();
}
