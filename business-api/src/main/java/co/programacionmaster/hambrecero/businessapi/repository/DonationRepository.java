package co.programacionmaster.hambrecero.businessapi.repository;

import co.programacionmaster.hambrecero.businessapi.model.Donation;
import io.vavr.control.Option;
import io.vavr.control.Try;
import javax.annotation.Nonnull;

public interface DonationRepository {

  @Nonnull
  Option<Donation> find(String id);

  @Nonnull
  Try<Donation> create(Donation donation);
}
