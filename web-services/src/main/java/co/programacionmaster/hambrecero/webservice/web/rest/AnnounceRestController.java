package co.programacionmaster.hambrecero.webservice.web.rest;

import co.programacionmaster.hambrecero.businessapi.enums.AnnounceStatus;
import co.programacionmaster.hambrecero.businessapi.model.Announce;
import co.programacionmaster.hambrecero.businessapi.service.AnnounceMutations;
import co.programacionmaster.hambrecero.businessapi.service.AnnounceQueries;
import co.programacionmaster.hambrecero.commons.exception.ResourceNotFoundException;
import co.programacionmaster.hambrecero.commons.utils.MessageUtils;
import co.programacionmaster.hambrecero.webservice.config.responses.SuccessResponse;
import co.programacionmaster.hambrecero.webservice.model.AnnounceDraftResource;
import co.programacionmaster.hambrecero.webservice.model.AnnounceResource;
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

  /**
   * Search and filter all {@link Announce}s.
   */
  @GetMapping("/search")
  public SuccessResponse<List<AnnounceResource>> search(Pageable pageable) {
    Page<AnnounceResource> response = announceQueries
        .search(pageable)
        .map(AnnounceResource::from);

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
   * Create a new {@link Announce}.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public SuccessResponse<AnnounceResource> create(
      @RequestBody @Valid AnnounceDraftResource draft,
      Principal principal
  ) {
    draft.setId(UUID.randomUUID().toString());
    draft.setStatus(AnnounceStatus.ACTIVE);
    draft.setCreatedBy(principal.getName());
    draft.setCreatedOn(LocalDateTime.now());

    Announce response = announceMutations.create(draft).get();
    return new SuccessResponse<>(AnnounceResource.from(response));
  }
}