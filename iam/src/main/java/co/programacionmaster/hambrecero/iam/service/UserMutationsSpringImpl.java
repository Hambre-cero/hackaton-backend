package co.programacionmaster.hambrecero.iam.service;

import co.programacionmaster.hambrecero.commons.exception.ResourceNotFoundException;
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

  private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,44}$";

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

  @Nonnull
  @Override
  public Try<User> updatePassword(
      String userId,
      String oldPassword,
      String newPassword,
      String newPasswordConfirmed
  ) {
    return Try.of(() -> {
      User user = userRepository
          .find(userId)
          .getOrElseThrow(() -> new ResourceNotFoundException(MessageUtils
              .getMessage(messageSource, "error.iam.user_not_found", userId)));

      if (!passwordEncoder.matches(oldPassword, user.getPassword().getOrNull())) {
        throw new IllegalArgumentException(MessageUtils
            .getMessage(messageSource, "error.iam.bad_old_password"));
      }

      if (!newPassword.equals(newPasswordConfirmed)) {
        throw new IllegalArgumentException(MessageUtils
            .getMessage(messageSource, "error.iam.password_must_be_equals_to_confirmed"));
      }

      if (newPassword.equals(oldPassword)) {
        throw new IllegalArgumentException(MessageUtils
            .getMessage(messageSource, "error.iam.password_must_be_different"));
      }

      validatePassword(newPassword).get();
      String encryptedPassword = passwordEncoder.encode(newPassword);
      return userRepository.update(user, encryptedPassword).get();
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
      if (!password.matches(PASSWORD_REGEX)) {
        throw new IllegalArgumentException(
            MessageUtils.getMessage(messageSource, "error.iam.invalid_password"));
      }
      return password;
    });
  }
}
