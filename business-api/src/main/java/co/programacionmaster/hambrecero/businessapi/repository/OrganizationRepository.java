package co.programacionmaster.hambrecero.businessapi.repository;

import co.programacionmaster.hambrecero.businessapi.model.Organization;
import io.vavr.control.Option;
import io.vavr.control.Try;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@ParametersAreNonnullByDefault
public interface OrganizationRepository {

  @Nonnull
  Option<Organization> find(String id);

  @Nonnull
  Option<Organization> findByIdentification(String identification);

  @Nonnull
  Page<Organization> search(Pageable pageable);

  @Nonnull
  Try<Organization> create(Organization organization);
}
