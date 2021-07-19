package co.programacionmaster.hambrecero.webservice.config;

import static co.programacionmaster.hambrecero.webservice.config.SecurityConstants.EXPIRATION_TIME;
import static co.programacionmaster.hambrecero.webservice.config.SecurityConstants.HEADER_STRING;
import static co.programacionmaster.hambrecero.webservice.config.SecurityConstants.SECRET;
import static co.programacionmaster.hambrecero.webservice.config.SecurityConstants.SUBJECT_HEADER_STRING;
import static co.programacionmaster.hambrecero.webservice.config.SecurityConstants.TOKEN_PREFIX;
import static com.auth0.jwt.algorithms.Algorithm.HMAC256;

import com.auth0.jwt.JWT;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Filter to handle authentication process with Spring Security integration.
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private AuthenticationManager authenticationManager;

  public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws AuthenticationException {
    String username = Objects.requireNonNull(obtainUsername(request), "username is required");
    String password = Objects.requireNonNull(obtainPassword(request), "password is required");
    username = username.trim();
    return authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            username,
            password,
            new ArrayList<>())
    );
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication auth
  ) throws IOException, ServletException {
    String subjectId = ((User) auth.getPrincipal()).getUsername();
    String token = JWT.create()
        .withSubject(subjectId)
        .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .sign(HMAC256(SECRET));
    response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    response.addHeader(SUBJECT_HEADER_STRING, subjectId);
  }
}
