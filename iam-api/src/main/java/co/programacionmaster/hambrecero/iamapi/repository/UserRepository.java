package co.programacionmaster.hambrecero.iamapi.repository;

import co.programacionmaster.hambrecero.iamapi.model.User;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface UserRepository {

  @Nonnull
  Option<User> find(String id);

  @Nonnull
  Option<User> findByEmailIgnoreCase(String email);
}
