package co.programacionmaster.hambrecero.business.persistence.repository;

import co.programacionmaster.hambrecero.business.persistence.model.DonationJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationJpaRepository extends JpaRepository<DonationJpa, String> {

}
