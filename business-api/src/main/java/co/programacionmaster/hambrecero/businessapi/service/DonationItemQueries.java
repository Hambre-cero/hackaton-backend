package co.programacionmaster.hambrecero.businessapi.service;

import co.programacionmaster.hambrecero.businessapi.model.DonationItem;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DonationItemQueries {

  @Nonnull
  Page<DonationItem> findByDonationId(String donationId, Pageable pageable);
}
