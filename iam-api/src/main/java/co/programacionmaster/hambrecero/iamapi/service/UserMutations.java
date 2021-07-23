package co.programacionmaster.hambrecero.iamapi.service;

import co.programacionmaster.hambrecero.iamapi.model.User;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * User mutation service contract.
 */
@ParametersAreNonnullByDefault
public interface UserMutations {

  @Nonnull
  Try<User> create(User user);

  @Nonnull
  Try<User> updatePassword(
      String userId,
      String oldPassword,
      String newPassword,
      String newPasswordConfirmed
  );
}
