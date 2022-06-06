package com.oshop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.oshop.validator.annotation.ExistsUsername;

public class ExistsUsernameValidator implements ConstraintValidator<ExistsUsername, String> {

	@Autowired
	UserRepository userRepository;

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if (!username.isBlank()) {
			return userRepository.existsByUsername(username);
		}
		return true;
	}
}
