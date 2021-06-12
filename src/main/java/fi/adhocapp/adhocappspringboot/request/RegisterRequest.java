package fi.adhocapp.adhocappspringboot.request;

import java.io.Serializable;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegisterRequest implements Serializable {

	private static final long serialVersionUID = 105893237592176243L;

	@NotBlank
	@Email(regexp = "(?=\\S+$).+@.+\\..+")
	private String email;
	
	@NotBlank
	private String password;
}
