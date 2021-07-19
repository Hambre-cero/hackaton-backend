package co.programacionmaster.hambrecero.iam.persistence.repository;

import co.programacionmaster.hambrecero.iam.persistence.model.UserJpa;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserJpa, String> {

  @Nonnull
  Option<UserJpa> findByEmailIgnoreCase(String email);
}