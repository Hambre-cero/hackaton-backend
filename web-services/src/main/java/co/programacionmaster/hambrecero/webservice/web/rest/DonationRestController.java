package co.programacionmaster.hambrecero.webservice.web.rest;

import co.programacionmaster.hambrecero.businessapi.enums.DonationStatus;
import co.programacionmaster.hambrecero.businessapi.model.Donation;
import co.programacionmaster.hambrecero.businessapi.model.DonationItem;
import co.programacionmaster.hambrecero.businessapi.service.DonationItemQueries;
import co.programacionmaster.hambrecero.businessapi.service.DonationMutations;
import co.programacionmaster.hambrecero.businessapi.service.DonationQueries;
import co.programacionmaster.hambrecero.commons.exception.ResourceNotFoundException;
import co.programacionmaster.hambrecero.commons.utils.MessageUtils;
import co.programacionmaster.hambrecero.webservice.config.responses.SuccessResponse;
import co.programacionmaster.hambrecero.webservice.model.DonationDraftResource;
import co.programacionmaster.hambrecero.webservice.model.DonationResource;
import co.programacionmaster.hambrecero.webservice.model.DonationItemResource;
import io.vavr.collection.List;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Donation rest controller.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/donations")
public class DonationRestController {

  private final DonationQueries donationQueries;
  private final DonationMutations donationMutations;
  private final DonationItemQueries donationItemQueries;
  private final MessageSource messageSource;

  /**
   * Find {@link Donation} by identifier.
   */
  @GetMapping("/{id}")
  public SuccessResponse<DonationResource> find(
      @PathVariable(value = "id") String id
  ) {
    Donation response = donationQueries
        .find(id)
        .getOrElseThrow(() -> new ResourceNotFoundException(MessageUtils
            .getMessage(messageSource, "error.web-services.donation_not_found", id)));
    return new SuccessResponse<>(DonationResource.from(response));
  }

  /**
   * Create a new {@link Donation}.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public SuccessResponse<DonationResource> create(
      @RequestBody @Valid DonationDraftResource draft,
      Principal principal
  ) {
    draft.setId(UUID.randomUUID().toString());
    draft.setStatus(DonationStatus.ACTIVE);
    draft.setCreatedBy(principal.getName());
    draft.setCreatedOn(LocalDateTime.now());

    Donation response = donationMutations.create(draft).get();
    return new SuccessResponse<>(DonationResource.from(response));
  }

  /**
   * Find {@link DonationItem}s by {@link Donation} identifier.
   */
  @GetMapping("/{donationId}/items")
  public SuccessResponse<List<DonationItemResource>> findByItemsByDonationId(
      @PathVariable(value = "donationId") String donationId,
      Pageable pageable
  ) {
    Page<DonationItemResource> response = donationItemQueries
        .findByDonationId(donationId, pageable)
        .map(DonationItemResource::from);

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