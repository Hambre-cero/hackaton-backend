package co.programacionmaster.hambrecero.webservice.web.rest;

import co.programacionmaster.hambrecero.commons.exception.ResourceNotFoundException;
import co.programacionmaster.hambrecero.iamapi.model.User;
import co.programacionmaster.hambrecero.iamapi.service.UserQueries;
import co.programacionmaster.hambrecero.webservice.model.UserResource;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User rest controller.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {

  private final UserQueries userQueries;

  /**
   * Find {@link User} by identifier.
   */
  @GetMapping("/{id}")
  public ResponseEntity<UserResource> find(
      @PathVariable(value = "id") String id
  ) {
    User user = userQueries
        .find(id)
        .getOrElseThrow(() -> new ResourceNotFoundException("User not found"));
    return ResponseEntity.ok(UserResource.from(user));
  }
}
