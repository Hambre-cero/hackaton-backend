package co.programacionmaster.hambrecero.business.repository;

import co.programacionmaster.hambrecero.business.persistence.model.OrganizationJpa;
import co.programacionmaster.hambrecero.business.persistence.repository.OrganizationJpaRepository;
import co.programacionmaster.hambrecero.businessapi.model.Organization;
import co.programacionmaster.hambrecero.businessapi.repository.OrganizationRepository;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class OrganizationRepositorySpringImpl implements OrganizationRepository {

  private final OrganizationJpaRepository organizationJpaRepository;

  @Nonnull
  @Override
  public Option<Organization> find(String id) {
    return Option.ofOptional(organizationJpaRepository.findById(id));
  }

  @Nonnull
  @Override
  public Page<Organization> search(Pageable pageable) {
    return organizationJpaRepository
        .search(pageable)
        .map(OrganizationJpa::narrow);
  }
}
