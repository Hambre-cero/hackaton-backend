package co.programacionmaster.hambrecero.webservice.web.rest;

import co.programacionmaster.hambrecero.businessapi.model.Donation;
import co.programacionmaster.hambrecero.businessapi.service.DonationQueries;
import co.programacionmaster.hambrecero.commons.exception.ResourceNotFoundException;
import co.programacionmaster.hambrecero.commons.utils.MessageUtils;
import co.programacionmaster.hambrecero.webservice.config.responses.SuccessResponse;
import co.programacionmaster.hambrecero.webservice.model.DonationResource;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Donation rest controller.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/donations")
public class DonationRestController {

  private final DonationQueries donationQueries;
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
}
