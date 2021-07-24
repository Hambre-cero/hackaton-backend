package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.model.DonationItem;
import co.programacionmaster.hambrecero.businessapi.repository.DonationItemRepository;
import co.programacionmaster.hambrecero.businessapi.service.DonationItemQueries;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class DonationItemQueriesSpringImpl implements DonationItemQueries {

  private final DonationItemRepository donationItemRepository;

  @Nonnull
  @Override
  public Page<DonationItem> findByDonationId(String donationId, Pageable pageable) {
    return donationItemRepository.findByDonationId(donationId, pageable);
  }
}
