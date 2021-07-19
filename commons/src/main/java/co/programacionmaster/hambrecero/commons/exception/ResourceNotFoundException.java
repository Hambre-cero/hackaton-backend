package co.programacionmaster.hambrecero.commons.exception;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Class for handle Resource Not Found exceptions.
 */
public class ResourceNotFoundException extends MainException {

  @SuppressFBWarnings("NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
  public ResourceNotFoundException() {
  }

  /**
   * All constructor.
   *
   * @param message Exception message
   * @param code    Unique error code
   * @param detail  Error message detail
   */
  public ResourceNotFoundException(String message, String code, String detail) {
    super(message, code, detail);
  }

  /**
   * Constructor with message.
   *
   * @param message Exception message
   */
  public ResourceNotFoundException(String message) {
    super(message);
  }
}