package co.programacionmaster.hambrecero.webservice.web.rest;

import static co.programacionmaster.hambrecero.webservice.config.SecurityConstants.EXPIRATION_TIME;
import static co.programacionmaster.hambrecero.webservice.config.SecurityConstants.HEADER_STRING;
import static co.programacionmaster.hambrecero.webservice.config.SecurityConstants.SECRET;
import static co.programacionmaster.hambrecero.webservice.config.SecurityConstants.TOKEN_PREFIX;
import static com.auth0.jwt.algorithms.Algorithm.HMAC256;

import co.programacionmaster.hambrecero.iamapi.model.User;
import co.programacionmaster.hambrecero.iamapi.model.enums.UserStatus;
import co.programacionmaster.hambrecero.iamapi.service.UserMutations;
import co.programacionmaster.hambrecero.webservice.model.LoginDraftResource;
import co.programacionmaster.hambrecero.webservice.model.UserDraftResource;
import co.programacionmaster.hambrecero.webservice.model.UserResource;
import com.auth0.jwt.JWT;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
  private final AuthenticationManager authenticationManager;

  @PostMapping("/login")
  public ResponseEntity<String> login(
      @RequestBody @Valid LoginDraftResource draft
  ) {
    UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
        draft.getUsername(),
        draft.getPassword()
    );

    Authentication auth = authenticationManager.authenticate(authReq);
    SecurityContext sc = SecurityContextHolder.getContext();
    sc.setAuthentication(auth);

    String token = JWT.create()
        .withSubject(auth.getName())
        .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .sign(HMAC256(SECRET));

    return ResponseEntity.ok()
        .header(HEADER_STRING, TOKEN_PREFIX + token)
        .body(token);
  }

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
