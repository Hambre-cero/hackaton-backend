package co.programacionmaster.hambrecero.commons.exception;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Getter;

/**
 * Main class for handle exceptions.
 */
@Getter
public class MainException extends RuntimeException {

  @Nonnull
  protected String code;

  @Nullable
  protected String detail;

  @SuppressFBWarnings("NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
  public MainException() {
  }

  /**
   * All constructor.
   *
   * @param message Exception message
   * @param code    Unique error code
   * @param detail  Error message detail
   */
  public MainException(final String message, String code, String detail) {
    super(message);
    this.code = code;
    this.detail = detail;
  }

  /**
   * Constructor with message.
   *
   * @param message Exception message
   */
  public MainException(final String message) {
    super(message);
    this.code = "temporal-code";
  }
}