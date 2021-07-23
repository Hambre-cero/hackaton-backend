package co.programacionmaster.hambrecero.webservice.model;

import co.programacionmaster.hambrecero.iamapi.model.User;
import co.programacionmaster.hambrecero.iamapi.model.enums.RoleId;
import co.programacionmaster.hambrecero.iamapi.model.enums.UserStatus;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDraftResource implements User {

  @Nullable
  private String id;

  @NotBlank
  private String name;

  @NotBlank
  private String email;

  @NotBlank
  private String password;

  @NotNull
  private RoleId roleId;

  @Nullable
  private String organizationId;

  @Nullable
  private UserStatus status;

  @Nullable
  private LocalDateTime createdOn;

  @Nullable
  private String createdBy;

  @Nonnull
  @Override
  public Option<String> getPassword() {
    return Option.of(password);
  }

  @Nonnull
  @Override
  public Option<String> getOrganizationId() {
    return Option.of(organizationId);
  }
}
