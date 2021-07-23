package co.programacionmaster.hambrecero.webservice.web.rest;

import co.programacionmaster.hambrecero.businessapi.model.Organization;
import co.programacionmaster.hambrecero.businessapi.service.OrganizationMutations;
import co.programacionmaster.hambrecero.businessapi.service.OrganizationQueries;
import co.programacionmaster.hambrecero.webservice.config.responses.SuccessResponse;
import co.programacionmaster.hambrecero.webservice.model.OrganizationResource;
import com.neovisionaries.i18n.CountryCode;
import io.vavr.collection.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Organization rest controller.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/organizations")
public class OrganizationRestController {

  private final OrganizationMutations organizationMutations;
  private final OrganizationQueries organizationQueries;

  /**
   * Search and filter all {@link Organization}s.
   */
  @GetMapping("/search")
  public SuccessResponse<List<OrganizationResource>> search(Pageable pageable) {
    Page<OrganizationResource> response = organizationQueries
        .search(pageable)
        .map(OrganizationResource::from);

    return new SuccessResponse(
        response.getContent(),
        response.getSize(),
        response.getTotalElements(),
        response.getTotalPages(),
        response.getNumberOfElements(),
        response.getNumber()
    );
  }
}