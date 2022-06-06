package com.oshop.dto.user;

import java.io.Serial;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.oshop.validator.annotation.ExistsEmail;
import com.oshop.validator.annotation.ValidEmail;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ForgotPass implements Serializable {

	@Serial
	private static final long serialVersionUID = -429837149030100931L;

	@NotBlank(message = "{NotBlank.email}")
    @ValidEmail(message = "{ValidEmail.email}")
    @ExistsEmail(message = "{ExistsEmail.email}")
    private String email;
}
