package co.programacionmaster.hambrecero.business.persistence.repository;

import co.programacionmaster.hambrecero.business.persistence.model.AnnounceJpa;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnnounceJpaRepository extends JpaRepository<AnnounceJpa, String> {

  @Query("select a from AnnounceJpa a")
  Page<AnnounceJpa> search(Pageable pageable);

  @Nonnull
  Page<AnnounceJpa> findByCreatedBy(String createdBy, Pageable pageable);
}
