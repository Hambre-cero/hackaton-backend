package co.programacionmaster.hambrecero.business.service;

import co.programacionmaster.hambrecero.businessapi.model.Organization;
import co.programacionmaster.hambrecero.businessapi.repository.OrganizationRepository;
import co.programacionmaster.hambrecero.businessapi.service.OrganizationMutations;
import co.programacionmaster.hambrecero.commons.utils.MessageUtils;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.NonUniqueResultException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ParametersAreNonnullByDefault
public class OrganizationMutationsSpringImpl implements OrganizationMutations {

  private final OrganizationRepository organizationRepository;
  private final MessageSource messageSource;

  @Nonnull
  @Override
  public Try<Organization> create(Organization organization) {
    return Try.of(() -> {
      if (organizationRepository
          .findByIdentification(organization.getIdentification())
          .isDefined()) {
        throw new NonUniqueResultException(MessageUtils
            .getMessage(messageSource, "error.business.organization_is_already_registered"));
      }

      return organizationRepository.create(organization).get();
    });
  }
}
