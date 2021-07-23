package co.programacionmaster.hambrecero.business.repository;

import co.programacionmaster.hambrecero.business.persistence.model.AnnounceJpa;
import co.programacionmaster.hambrecero.business.persistence.repository.AnnounceJpaRepository;
import co.programacionmaster.hambrecero.businessapi.model.Announce;
import co.programacionmaster.hambrecero.businessapi.repository.AnnounceRepository;
import io.vavr.control.Option;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class AnnounceRepositorySpringImpl implements AnnounceRepository {

  private final AnnounceJpaRepository announceJpaRepository;

  @Nonnull
  @Override
  public Option<Announce> find(String id) {
    return Option.ofOptional(announceJpaRepository.findById(id));
  }

  @Nonnull
  @Override
  public Try<Announce> create(Announce announce) {
    return Try.of(() -> announceJpaRepository.save(AnnounceJpa.from(announce)));
  }
}
