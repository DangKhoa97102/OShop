package com.oshop.dto.user;

import java.io.Serial;
import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotBlank;

import com.oshop.validator.annotation.NotExistsEmail;
import com.oshop.validator.annotation.NotExistsUsername;
import com.oshop.validator.annotation.PasswordMatches;
import com.oshop.validator.annotation.ValidEmail;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@PasswordMatches
public class Register implements Serializable {
	@Serial
	private static final long serialVersionUID = 865155294138239437L;

    @NotBlank(message = "{NotBlank.firstName}")
    private String firstName;
    @NotBlank(message = "{NotBlank.lastName}")
    private String lastName;
    @NotBlank(message = "{NotBlank.username}")
    @NotExistsUsername(message = "{NotExistsUsername}")
    private String username;
    @NotBlank(message = "{NotBlank.email}")
    @ValidEmail(message = "{ValidEmail}")
    @NotExistsEmail(message = "{NotExistsEmail}")
    private String email;
    @NotBlank(message = "{NotBlank.password}")
    private String password;
    @NotBlank(message = "{NotBlank.passwordConfirm}")
    private String passwordConfirm;

    public String getFullname() {
        return Stream
                .of(lastName, firstName)
                .filter(x -> x != null && !x.isBlank())
                .collect(Collectors.joining(" "));
    }
}
