package co.programacionmaster.hambrecero.business.persistence.repository;

import co.programacionmaster.hambrecero.business.persistence.model.AnnounceJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnounceJpaRepository extends JpaRepository<AnnounceJpa, String> {

}
