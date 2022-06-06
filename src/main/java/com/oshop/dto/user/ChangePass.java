package com.oshop.dto.user;

import java.io.Serial;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.oshop.validator.annotation.ExistsPassword;
import com.oshop.validator.annotation.NotExistsPassword;
import com.oshop.validator.annotation.PasswordMatches;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@PasswordMatches(message = "{PasswordMatches}")
@NotExistsPassword(message = "{NotExistsPassword}")
@ExistsPassword(message = "{ExistsPassword}")
public class ChangePass implements Serializable {

	@Serial
	private static final long serialVersionUID = 4329982954837684125L;

	@NotBlank(message = "{NotBlank.password}")
	private String oldPassword;
	@NotBlank(message = "{NotBlank.password}")
	private String newPassword;
	@NotBlank(message = "{NotBlank.passwordConfirm}")
	private String newPasswordConfirm;
}
