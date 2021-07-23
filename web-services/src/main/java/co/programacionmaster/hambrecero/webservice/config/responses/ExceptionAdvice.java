package co.programacionmaster.hambrecero.webservice.config.responses;

import co.programacionmaster.hambrecero.commons.exception.BadArgumentException;
import co.programacionmaster.hambrecero.commons.exception.ResourceNotFoundException;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

  /**
   * Handle any {@link Exception}.
   *
   * @param ex Any exception
   * @return A new instance {@link ErrorResponse} (error formatted)
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse handleInternalServerError(Exception ex) {
    return ErrorResponse.from(
        "temporal-code",
        ex.getMessage(),
        null,
        LocalDateTime.now(),
        HttpStatus.INTERNAL_SERVER_ERROR.value()
    );
  }

  /**
   * Handle {@link ResourceNotFoundException}.
   *
   * @param ex Other {@link ResourceNotFoundException} instanca
   * @return A new instance {@link ErrorResponse} (error formatted)
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleNotFoundError(ResourceNotFoundException ex) {
    return ErrorResponse.from(
        ex.getCode(),
        ex.getMessage(),
        ex.getDetail(),
        LocalDateTime.now(),
        HttpStatus.NOT_FOUND.value()
    );
  }

  /**
   * Handle {@link BadArgumentException}.
   *
   * @param ex Other {@link BadArgumentException} instanca
   * @return A new instance {@link ErrorResponse} (error formatted)
   */
  @ExceptionHandler(BadArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleBadArgumentError(BadArgumentException ex) {
    return ErrorResponse.from(
        ex.getCode(),
        ex.getMessage(),
        ex.getDetail(),
        LocalDateTime.now(),
        HttpStatus.BAD_REQUEST.value()
    );
  }
}
