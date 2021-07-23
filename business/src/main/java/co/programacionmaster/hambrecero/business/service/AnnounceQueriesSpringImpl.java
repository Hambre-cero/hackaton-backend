package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.model.Announce;
import co.programacionmaster.hambrecero.businessapi.repository.AnnounceRepository;
import co.programacionmaster.hambrecero.businessapi.service.AnnounceQueries;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.AllArgsConstructor;
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
}
