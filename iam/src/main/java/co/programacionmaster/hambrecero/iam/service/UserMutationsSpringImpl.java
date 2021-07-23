package co.programacionmaster.hambrecero.iam.service;

import co.programacionmaster.hambrecero.commons.utils.MessageUtils;
import co.programacionmaster.hambrecero.iamapi.model.User;
import co.programacionmaster.hambrecero.iamapi.repository.UserRepository;
import co.programacionmaster.hambrecero.iamapi.service.UserMutations;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.NonUniqueResultException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class UserMutationsSpringImpl implements UserMutations {

  private static final String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,44}$";

  private final UserRepository userRepository;
  private final MessageSource messageSource;
  private final BCryptPasswordEncoder passwordEncoder;

  @Nonnull
  @Override
  public Try<User> create(User user) {
    return Try.of(() -> {
      if (userRepository.findByEmailIgnoreCase(user.getEmail()).isDefined()) {
        throw new NonUniqueResultException(MessageUtils
            .getMessage(messageSource, "error.iam.user_is_already_registered"));
      }

      validatePassword(user.getPassword().getOrNull()).get();
      String encryptedPassword = passwordEncoder.encode(user.getPassword().getOrNull());
      return userRepository.create(user, encryptedPassword).get();
    });
  }

  /**
   * Validate if password pass password rules.
   *
   * @param password Password to validate
   * @return Validated password
   */
  private Try<String> validatePassword(String password) {
    return Try.of(() -> {
      if (!password.matches(passwordRegex)) {
        throw new IllegalArgumentException(
            MessageUtils.getMessage(messageSource, "error.iam.invalid_password"));
      }
      return password;
    });
  }
}
