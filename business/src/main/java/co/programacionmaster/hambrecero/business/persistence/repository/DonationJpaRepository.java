package co.programacionmaster.hambrecero.business.persistence.repository;

import co.programacionmaster.hambrecero.business.persistence.model.DonationJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonationJpaRepository extends JpaRepository<DonationJpa, String> {

  @Query("select a from DonationJpa a")
  Page<DonationJpa> search(Pageable pageable);
}
