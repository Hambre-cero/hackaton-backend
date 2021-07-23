package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.model.Announce;
import co.programacionmaster.hambrecero.businessapi.repository.AnnounceRepository;
import co.programacionmaster.hambrecero.businessapi.service.AnnounceMutations;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class AnnounceMutationsSpringImpl implements AnnounceMutations {

  private final AnnounceRepository announceRepository;

  @Nonnull
  @Override
  public Try<Announce> create(Announce announce) {
    return Try.of(() -> announceRepository.create(announce).get());
  }
}
