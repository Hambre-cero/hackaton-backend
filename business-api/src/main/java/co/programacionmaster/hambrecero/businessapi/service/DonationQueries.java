package co.programacionmaster.hambrecero.businessapi.service;

import co.programacionmaster.hambrecero.businessapi.model.Donation;
import io.vavr.control.Option;
import javax.annotation.Nonnull;

public interface DonationQueries {

  @Nonnull
  Option<Donation> find(String id);
}
