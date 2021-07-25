package co.programacionmaster.hambrecero.webservice.model;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDraftResource {

  @NotBlank
  private String username;

  @NotBlank
  private String password;
}
