package co.programacionmaster.hambrecero.webservice.config;

/**
 * Spring security constants used in the authentication and authorization process.
 */
public final class SecurityConstants {

  public static final String SECRET = "TuMeseroWebServicesKey";
  public static final long EXPIRATION_TIME = 864_000_000; // 10 days
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String SUBJECT_HEADER_STRING = "Subject";

  private SecurityConstants() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
}