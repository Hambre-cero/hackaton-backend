package co.programacionmaster.hambrecero.businessapi.repository;

import co.programacionmaster.hambrecero.businessapi.model.Donation;
import io.vavr.control.Option;
import javax.annotation.Nonnull;

public interface DonationRepository {

  @Nonnull
  Option<Donation> find(String id);
}
