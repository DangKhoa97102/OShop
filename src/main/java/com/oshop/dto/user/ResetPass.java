package com.oshop.dto.user;

import java.io.Serial;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.oshop.validator.annotation.NotExistsPassword;
import com.oshop.validator.annotation.PasswordMatches;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@PasswordMatches(message = "{PasswordMatches}")
@NotExistsPassword(message = "{NotExistsPassword}")
public class ResetPass implements Serializable {
	@Serial
	private static final long serialVersionUID = 8194105896366882389L;

	private String token;
	@NotBlank(message = "{NotBlank.password}")
	private String password;
	@NotBlank(message = "{NotBlank.passwordConfirm")
	private String passwordConfirm;
}
