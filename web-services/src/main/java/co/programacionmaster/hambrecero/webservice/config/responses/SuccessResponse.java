package co.programacionmaster.hambrecero.webservice.config.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse<T> implements java.io.Serializable {

  @Nonnull
  private T response;

  @Nullable
  private Integer size;

  @Nullable
  private Long totalElements;

  @Nullable
  private Integer totalPages;

  @Nullable
  private Integer numberOfElements;

  @Nullable
  private Integer number;

  @Nullable
  private String message;

  /**
   * Constructor.
   *
   * @param response Success object response
   */
  public SuccessResponse(T response) {
    this.response = response;
    setValidLength();
  }

  /**
   * Constructor.
   *
   * @param response Success object response
   * @param message  Optional message
   */
  public SuccessResponse(T response, String message) {
    this.response = response;
    this.message = message;
    setValidLength();
  }

  /**
   * Constructor.
   */
  public SuccessResponse(T response, Integer size, Long totalElements, Integer totalPages,
      Integer numberOfElements, Integer number) {
    this.response = response;
    this.size = size;
    this.totalElements = totalElements;
    this.totalPages = totalPages;
    this.numberOfElements = numberOfElements;
    this.number = number;
  }

  private void setValidLength() {
    if (this.response instanceof List) {
      this.size = ((List) this.response).size();
    } else if (this.response instanceof io.vavr.collection.List) {
      this.size = ((io.vavr.collection.List) this.response).size();
    } else if (this.response instanceof Map) {
      this.size = ((Map) this.response).size();
    }
  }
}