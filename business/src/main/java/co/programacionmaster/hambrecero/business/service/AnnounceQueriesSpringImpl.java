package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.model.Announce;
import co.programacionmaster.hambrecero.businessapi.repository.AnnounceRepository;
import co.programacionmaster.hambrecero.businessapi.service.AnnounceQueries;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class AnnounceQueriesSpringImpl implements AnnounceQueries {

  private final AnnounceRepository announceRepository;

  @Nonnull
  @Override
  public Option<Announce> find(String id) {
    return announceRepository.find(id);
  }

  @Nonnull
  @Override
  public Page<Announce> search(Pageable pageable) {
    return announceRepository.search(pageable);
  }

  @Nonnull
  @Override
  public Page<Announce> findByCreatedBy(String createdBy, Pageable pageable) {
    return announceRepository.findByCreatedBy(createdBy, pageable);
  }
}
