package co.programacionmaster.hambrecero.business.repository;

import co.programacionmaster.hambrecero.business.persistence.model.DonationItemJpa;
import co.programacionmaster.hambrecero.business.persistence.repository.DonationItemJpaRepository;
import co.programacionmaster.hambrecero.businessapi.model.DonationItem;
import co.programacionmaster.hambrecero.businessapi.repository.DonationItemRepository;
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
public class DonationItemRepositorySpringImpl implements DonationItemRepository {

  private final DonationItemJpaRepository donationItemJpaRepository;

  @Nonnull
  @Override
  public Page<DonationItem> findByDonationId(String donationId, Pageable pageable) {
    return donationItemJpaRepository.findByDonationId(donationId, pageable)
        .map(DonationItemJpa::narrow);
  }
}
