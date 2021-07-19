package co.programacionmaster.hambrecero.iam.service;

import co.programacionmaster.hambrecero.iamapi.model.User;
import co.programacionmaster.hambrecero.iamapi.repository.UserRepository;
import co.programacionmaster.hambrecero.iamapi.service.UserQueries;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserQueriesSpringImpl implements UserQueries {

  private final UserRepository userRepository;

  @Nonnull
  @Override
  public Option<User> find(String id) {
    return userRepository.find(id);
  }

  @Nonnull
  @Override
  public Option<User> findByEmail(String email) {
    return userRepository.findByEmailIgnoreCase(email);
  }
}
