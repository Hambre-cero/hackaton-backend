package co.programacionmaster.hambrecero.businessapi.repository;

import co.programacionmaster.hambrecero.businessapi.model.Announce;
import io.vavr.control.Option;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnnounceRepository {

  @Nonnull
  Option<Announce> find(String id);

  @Nonnull
  Page<Announce> search(Pageable pageable);

  @Nonnull
  Page<Announce> findByCreatedBy(String createdBy, Pageable pageable);

  @Nonnull
  Try<Announce> create(Announce announce);
}
