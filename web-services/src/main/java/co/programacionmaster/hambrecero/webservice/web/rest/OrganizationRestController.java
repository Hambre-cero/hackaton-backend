package co.programacionmaster.hambrecero.webservice.web.rest;

import co.programacionmaster.hambrecero.businessapi.enums.OrganizationStatus;
import co.programacionmaster.hambrecero.businessapi.model.Organization;
import co.programacionmaster.hambrecero.businessapi.service.OrganizationMutations;
import co.programacionmaster.hambrecero.businessapi.service.OrganizationQueries;
import co.programacionmaster.hambrecero.webservice.config.responses.SuccessResponse;
import co.programacionmaster.hambrecero.webservice.model.OrganizationDraftResource;
import co.programacionmaster.hambrecero.webservice.model.OrganizationResource;
import io.vavr.collection.List;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  /**
   * Create a new {@link Organization}.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public SuccessResponse<OrganizationResource> create(
      @RequestBody @Valid OrganizationDraftResource draft,
      Principal principal
  ) {
    draft.setId(UUID.randomUUID().toString());
    draft.setStatus(OrganizationStatus.ACTIVE);
    draft.setCreatedBy(principal.getName());
    draft.setCreatedOn(LocalDateTime.now());

    Organization response = organizationMutations.create(draft).get();
    return new SuccessResponse<>(OrganizationResource.from(response));
  }
}