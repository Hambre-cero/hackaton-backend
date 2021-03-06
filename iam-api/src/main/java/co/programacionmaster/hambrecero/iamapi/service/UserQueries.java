package co.programacionmaster.hambrecero.iamapi.service;

import co.programacionmaster.hambrecero.iamapi.model.User;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface UserQueries {

  @Nonnull
  Option<User> find(String id);

  @Nonnull
  Option<User> findByEmail(String email);
}