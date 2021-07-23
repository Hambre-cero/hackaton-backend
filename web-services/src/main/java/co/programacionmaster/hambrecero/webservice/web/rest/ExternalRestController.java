package co.programacionmaster.hambrecero.webservice.web.rest;

import co.programacionmaster.hambrecero.businessapi.service.OrganizationQueries;
import co.programacionmaster.hambrecero.iamapi.model.User;
import co.programacionmaster.hambrecero.iamapi.model.enums.UserStatus;
import co.programacionmaster.hambrecero.iamapi.service.UserMutations;
import co.programacionmaster.hambrecero.webservice.model.UserDraftResource;
import co.programacionmaster.hambrecero.webservice.model.UserResource;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * External rest controller (it is not required that the user is logged in).
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/external")
public class ExternalRestController {

  private final UserMutations userMutations;

  /**
   * Create a new {@link User}.
   */
  @PostMapping("/sign-up")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserResource> createUser(
      @RequestBody @Valid UserDraftResource draft
  ) {
    var userId = UUID.randomUUID().toString();
    draft.setId(userId);
    draft.setStatus(UserStatus.ACTIVE);
    draft.setCreatedOn(LocalDateTime.now());
    draft.setCreatedBy(userId);

    User response = userMutations.create(draft).get();
    return ResponseEntity.ok(UserResource.from(response));
  }
}
