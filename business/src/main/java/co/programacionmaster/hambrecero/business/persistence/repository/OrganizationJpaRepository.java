package co.programacionmaster.hambrecero.business.persistence.repository;

import co.programacionmaster.hambrecero.business.persistence.model.OrganizationJpa;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrganizationJpaRepository extends JpaRepository<OrganizationJpa, String> {

  @Nonnull
  Option<OrganizationJpa> findByIdentification(String identification);

  @Query("select o from OrganizationJpa o")
  Page<OrganizationJpa> search(Pageable pageable);
}
