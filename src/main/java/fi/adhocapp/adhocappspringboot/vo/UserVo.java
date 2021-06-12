package fi.adhocapp.adhocappspringboot.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserVo {
	
	@NotBlank
	private Long id;
	
	private String email;

	private Boolean emailVerify;
	
}
