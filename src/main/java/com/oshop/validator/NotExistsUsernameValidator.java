package com.oshop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.oshop.repository.UserRepository;
import com.oshop.validator.annotation.NotExistsUsername;

public class NotExistsUsernameValidator implements ConstraintValidator<NotExistsUsername, String> {

	@Autowired
    UserRepository userRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 if (!value.isBlank()) {
	            return !userRepository.existsByUsername(value);
	        }
	        return true;
	}
	
}
