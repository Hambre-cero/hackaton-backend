package co.programacionmaster.hambrecero.businessapi.repository;

import co.programacionmaster.hambrecero.businessapi.model.Donation;
import io.vavr.control.Option;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DonationRepository {

  @Nonnull
  Option<Donation> find(String id);

  @Nonnull
  Try<Donation> create(Donation donation);

  @Nonnull
  Page<Donation> search(Pageable pageable);
}
