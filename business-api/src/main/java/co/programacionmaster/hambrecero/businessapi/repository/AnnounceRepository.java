package co.programacionmaster.hambrecero.businessapi.repository;

import co.programacionmaster.hambrecero.businessapi.model.Announce;
import io.vavr.control.Option;
import javax.annotation.Nonnull;

public interface AnnounceRepository {

  @Nonnull
  Option<Announce> find(String id);
}
