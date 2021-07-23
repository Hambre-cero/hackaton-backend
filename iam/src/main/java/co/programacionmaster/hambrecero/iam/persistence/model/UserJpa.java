package co.programacionmaster.hambrecero.iam.persistence.model;

import co.programacionmaster.hambrecero.iamapi.model.User;
import co.programacionmaster.hambrecero.iamapi.model.enums.RoleId;
import co.programacionmaster.hambrecero.iamapi.model.enums.UserStatus;
import co.programacionmaster.hambrecero.iamapi.model.values.UserValue;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.vavr.control.Option;
import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "users")
public class UserJpa implements User {

  @Id
  @Nonnull
  private String id;

  @Nonnull
  private String name;

  @Nonnull
  private String email;

  @Nullable
  private String password;

  @Nonnull
  @Enumerated(EnumType.STRING)
  private RoleId roleId;

  @Nullable
  private String organizationId;

  @Nonnull
  @Enumerated(EnumType.STRING)
  private UserStatus status;

  @Nonnull
  private LocalDateTime createdOn;

  @Nonnull
  private String createdBy;

  /**
   * Private default constructor for JPA.
   */
  @SuppressFBWarnings("NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
  private UserJpa() {
  }

  /**
   * Static factory method.
   *
   * @param other Other {@link User}
   * @return A new {@link UserJpa} instance
   */
  @Nonnull
  public static UserJpa from(@Nonnull User other) {
    return new UserJpa(
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

  public User narrow() {
    return UserValue.from(this);
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