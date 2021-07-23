package co.programacionmaster.hambrecero.webservice.config.responses;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

  private ErrorResponseDto error;

  /**
   * Static factory method.
   *
   * @param code      Unique error message code
   * @param title     Error title
   * @param detail    Detail title
   * @param timestamp Current time
   * @param status    Http Status code
   * @return A new {@link ErrorResponse} instance
   */
  public static ErrorResponse from(
      String code,
      String title,
      String detail,
      LocalDateTime timestamp,
      Integer status
  ) {
    return new ErrorResponse(new ErrorResponseDto(code, title, detail, timestamp, status));
  }
}