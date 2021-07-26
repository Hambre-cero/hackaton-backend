package co.programacionmaster.hambrecero.businessapi.service;

import co.programacionmaster.hambrecero.businessapi.model.Organization;
import co.programacionmaster.hambrecero.businessapi.model.Organization;
import io.vavr.control.Option;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@ParametersAreNonnullByDefault
public interface OrganizationQueries {

  @Nonnull
  Option<Organization> find(String id);
  
  @Nonnull
  Page<Organization> search(Pageable pageable);
}