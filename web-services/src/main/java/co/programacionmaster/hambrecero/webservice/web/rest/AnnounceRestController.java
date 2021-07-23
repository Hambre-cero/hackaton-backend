package co.programacionmaster.hambrecero.webservice.web.rest;

import co.programacionmaster.hambrecero.businessapi.model.Announce;
import co.programacionmaster.hambrecero.businessapi.service.AnnounceMutations;
import co.programacionmaster.hambrecero.businessapi.service.AnnounceQueries;
import co.programacionmaster.hambrecero.commons.exception.ResourceNotFoundException;
import co.programacionmaster.hambrecero.commons.utils.MessageUtils;
import co.programacionmaster.hambrecero.webservice.config.responses.SuccessResponse;
import co.programacionmaster.hambrecero.webservice.model.AnnounceResource;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Announce rest controller.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/announces")
public class AnnounceRestController {

  private final AnnounceMutations announceMutations;
  private final AnnounceQueries announceQueries;
  private final MessageSource messageSource;

  /**
   * Find {@link Announce} by identifier.
   */
  @GetMapping("/{id}")
  public SuccessResponse<AnnounceResource> find(
      @PathVariable(value = "id") String id
  ) {
    Announce response = announceQueries
        .find(id)
        .getOrElseThrow(() -> new ResourceNotFoundException(MessageUtils
            .getMessage(messageSource, "error.web-services.announce_not_found", id)));
    return new SuccessResponse<>(AnnounceResource.from(response));
  }
}
