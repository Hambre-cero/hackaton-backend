package co.programacionmaster.hambrecero.businessapi.service;

import co.programacionmaster.hambrecero.businessapi.model.Announce;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnnounceQueries {

  @Nonnull
  Option<Announce> find(String id);

  @Nonnull
  Page<Announce> search(Pageable pageable);
}
