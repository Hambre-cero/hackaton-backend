package co.programacionmaster.hambrecero.iam.repository;

import co.programacionmaster.hambrecero.iam.persistence.model.UserJpa;
import co.programacionmaster.hambrecero.iam.persistence.repository.UserJpaRepository;
import co.programacionmaster.hambrecero.iamapi.model.User;
import co.programacionmaster.hambrecero.iamapi.repository.UserRepository;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class UserRepositorySpringImpl implements UserRepository {

  private final UserJpaRepository userJpaRepository;

  @Nonnull
  @Override
  public Option<User> find(String id) {
    return Option.ofOptional(userJpaRepository.findById(id));
  }

  @Nonnull
  @Override
  public Option<User> findByEmailIgnoreCase(String email) {
    return userJpaRepository.findByEmailIgnoreCase(email).map(UserJpa::narrow);
  }
}