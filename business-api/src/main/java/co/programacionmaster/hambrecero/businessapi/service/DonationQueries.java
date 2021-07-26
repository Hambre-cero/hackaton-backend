package co.programacionmaster.hambrecero.businessapi.service;

import co.programacionmaster.hambrecero.businessapi.model.Donation;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DonationQueries {

  @Nonnull
  Option<Donation> find(String id);

  @Nonnull
  Page<Donation> search(Pageable pageable);
}
