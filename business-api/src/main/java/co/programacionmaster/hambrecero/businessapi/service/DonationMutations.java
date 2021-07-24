package co.programacionmaster.hambrecero.businessapi.service;

import co.programacionmaster.hambrecero.businessapi.model.Donation;
import io.vavr.control.Try;
import javax.annotation.Nonnull;

public interface DonationMutations {

  @Nonnull
  Try<Donation> create(Donation donation);
}
