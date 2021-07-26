package co.programacionmaster.hambrecero.business.repository;

import co.programacionmaster.hambrecero.business.persistence.model.DonationJpa;
import co.programacionmaster.hambrecero.business.persistence.repository.DonationJpaRepository;
import co.programacionmaster.hambrecero.businessapi.model.Donation;
import co.programacionmaster.hambrecero.businessapi.repository.DonationRepository;
import io.vavr.control.Option;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class DonationRepositorySpringImpl implements DonationRepository {

  private final DonationJpaRepository donationJpaRepository;

  @Nonnull
  @Override
  public Option<Donation> find(String id) {
    return Option.ofOptional(donationJpaRepository.findById(id));
  }

  @Nonnull
  @Override
  public Try<Donation> create(Donation donation) {
    return Try.of(() -> donationJpaRepository.save(DonationJpa.from(donation)));
  }

  @Nonnull
  @Override
  public Page<Donation> search(Pageable pageable) {
    return donationJpaRepository.search(pageable).map(DonationJpa::narrow);
  }
}
