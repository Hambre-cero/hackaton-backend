package co.programacionmaster.hambrecero.businessapi.service;

import co.programacionmaster.hambrecero.businessapi.model.Announce;
import io.vavr.control.Option;
import javax.annotation.Nonnull;

public interface AnnounceQueries {

  @Nonnull
  Option<Announce> find(String id);
}
