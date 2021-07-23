package co.programacionmaster.hambrecero.business.persistence.repository;

import co.programacionmaster.hambrecero.business.persistence.model.OrganizationJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrganizationJpaRepository extends JpaRepository<OrganizationJpa, String> {

  @Query("select o from OrganizationJpa o")
  Page<OrganizationJpa> search(Pageable pageable);
}
