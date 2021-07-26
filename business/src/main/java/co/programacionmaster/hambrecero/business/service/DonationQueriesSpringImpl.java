package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.model.Donation;
import co.programacionmaster.hambrecero.businessapi.repository.DonationRepository;
import co.programacionmaster.hambrecero.businessapi.service.DonationQueries;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class DonationQueriesSpringImpl implements DonationQueries {

  private final DonationRepository donationRepository;

  @Nonnull
  @Override
  public Option<Donation> find(String id) {
    return donationRepository.find(id);
  }

  @Nonnull
  @Override
  public Page<Donation> search(Pageable pageable) {
    return donationRepository.search(pageable);
  }
}
