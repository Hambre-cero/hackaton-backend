package co.programacionmaster.hambrecero.business.persistence.repository;

import co.programacionmaster.hambrecero.business.persistence.model.DonationItemJpa;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationItemJpaRepository extends JpaRepository<DonationItemJpa, String> {

  @Nonnull
  Page<DonationItemJpa> findByDonationId(String donationId, Pageable pageable);
}
