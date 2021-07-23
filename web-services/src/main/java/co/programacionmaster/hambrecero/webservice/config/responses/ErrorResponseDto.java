package co.programacionmaster.hambrecero.webservice.config.responses;

import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto implements java.io.Serializable {

  @Nonnull
  private String code;

  @Nonnull
  private String title;

  @Nullable
  private String detail;

  @Nonnull
  private LocalDateTime timestamp;

  @Nonnull
  private Integer status;
}