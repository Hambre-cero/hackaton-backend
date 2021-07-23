package co.programacionmaster.hambrecero.businessapi.service;

import co.programacionmaster.hambrecero.businessapi.model.Announce;
import io.vavr.control.Try;
import javax.annotation.Nonnull;

public interface AnnounceMutations {

  @Nonnull
  Try<Announce> create(Announce announce);
}
