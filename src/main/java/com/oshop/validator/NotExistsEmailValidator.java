package com.oshop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.oshop.validator.annotation.NotExistsEmail;

public class NotExistsEmailValidator implements ConstraintValidator<NotExistsEmail, String> {

	@Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!value.isBlank()) {
            return !userRepository.existsByEmail(value);
        }
        return true;
    }
}
