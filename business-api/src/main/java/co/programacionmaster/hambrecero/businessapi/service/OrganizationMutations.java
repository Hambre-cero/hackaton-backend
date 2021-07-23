package co.programacionmaster.hambrecero.businessapi.service;

import co.programacionmaster.hambrecero.businessapi.model.Organization;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface OrganizationMutations {

  @Nonnull
  Try<Organization> create(Organization organization);
}