package co.programacionmaster.hambrecero.commons.exception;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Class for handle Bad Argument exceptions.
 */
public class BadArgumentException extends MainException {

  @SuppressFBWarnings("NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
  public BadArgumentException() {
  }

  /**
   * All constructor.
   *
   * @param message Exception message
   * @param code    Unique error code
   * @param detail  Error message detail
   */
  public BadArgumentException(String message, String code, String detail) {
    super(message, code, detail);
  }

  /**
   * Constructor with message.
   *
   * @param message Exception message
   */
  public BadArgumentException(String message) {
    super(message);
  }
}