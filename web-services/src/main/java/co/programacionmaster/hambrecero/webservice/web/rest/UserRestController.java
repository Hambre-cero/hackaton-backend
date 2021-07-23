package co.programacionmaster.hambrecero.webservice.web.rest;

import co.programacionmaster.hambrecero.commons.exception.ResourceNotFoundException;
import co.programacionmaster.hambrecero.commons.utils.MessageUtils;
import co.programacionmaster.hambrecero.iamapi.model.User;
import co.programacionmaster.hambrecero.iamapi.service.UserMutations;
import co.programacionmaster.hambrecero.iamapi.service.UserQueries;
import co.programacionmaster.hambrecero.webservice.config.responses.SuccessResponse;
import co.programacionmaster.hambrecero.webservice.model.UpdatePasswordDraftResource;
import co.programacionmaster.hambrecero.webservice.model.UserResource;
import java.security.Principal;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
  private final UserMutations userMutations;
  private final MessageSource messageSource;

  /**
   * Find {@link User} by identifier.
   */
  @GetMapping("/{id}")
  public SuccessResponse<UserResource> find(
      @PathVariable(value = "id") String id
  ) {
    User user = userQueries
        .find(id)
        .getOrElseThrow(() -> new ResourceNotFoundException("User not found"));
    return new SuccessResponse<>(UserResource.from(user));
  }

  /**
   * Find {@link User} by current user logged-in identifier.
   */
  @GetMapping("/me")
  public SuccessResponse<UserResource> me(Principal principal) {
    User user = userQueries
        .find(principal.getName())
        .getOrElseThrow(() -> new ResourceNotFoundException(MessageUtils
            .getMessage(messageSource, "error.web-services.user_not_found", principal.getName())));
    return new SuccessResponse<>(UserResource.from(user));
  }

  /**
   * Update password for current logged in user.
   */
  @PatchMapping("/password")
  public SuccessResponse<UserResource> updatePassword(
      Principal principal,
      @RequestBody @Valid UpdatePasswordDraftResource draft
  ) {
    return new SuccessResponse<>(UserResource.from(
        userMutations
            .updatePassword(
                principal.getName(),
                draft.getOldPassword(),
                draft.getNewPassword(),
                draft.getNewPasswordConfirmation())
            .get())
    );
  }
}
