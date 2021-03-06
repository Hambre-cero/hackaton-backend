package co.programacionmaster.hambrecero.iamapi.repository;

import co.programacionmaster.hambrecero.iamapi.model.User;
import io.vavr.control.Option;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface UserRepository {

  @Nonnull
  Option<User> find(String id);

  @Nonnull
  Option<User> findByEmailIgnoreCase(String email);

  @Nonnull
  Try<User> create(User user, String encryptedPassword);

  @Nonnull
  Try<User> update(User user, String encryptedPassword);
}
