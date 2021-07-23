package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.model.Organization;
import co.programacionmaster.hambrecero.businessapi.repository.OrganizationRepository;
import co.programacionmaster.hambrecero.businessapi.service.OrganizationQueries;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class OrganizationQueriesSpringImpl implements OrganizationQueries {

  private final OrganizationRepository organizationRepository;

  @Nonnull
  @Override
  public Page<Organization> search(Pageable pageable) {
    return organizationRepository.search(pageable);
  }
}
