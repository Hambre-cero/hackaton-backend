package co.programacionmaster.hambrecero.iamapi.model.values;

import co.programacionmaster.hambrecero.iamapi.model.User;
import co.programacionmaster.hambrecero.iamapi.model.enums.RoleId;
import co.programacionmaster.hambrecero.iamapi.model.enums.UserStatus;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class UserValue implements User {

  @Nonnull
  private String id;

  @Nonnull
  private String name;

  @Nonnull
  private String email;

  @Nullable
  private String password;

  @Nonnull
  private RoleId roleId;

  @Nullable
  private String organizationId;

  @Nonnull
  private UserStatus status;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Static factory method.
   *
   * @param other Other {@link User}
   * @return A new {@link UserValue} instance
   */
  @Nonnull
  public static UserValue from(@Nonnull User other) {
    return new UserValue(
        other.getId(),
        other.getName(),
        other.getEmail(),
        other.getPassword().getOrNull(),
        other.getRoleId(),
        other.getOrganizationId().getOrNull(),
        other.getStatus(),
        other.getCreatedOn(),
        other.getCreatedBy()
    );
  }

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