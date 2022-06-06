package com.oshop.validator.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.oshop.validator.NotExistsEmailValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = NotExistsEmailValidator.class)
@Documented
public @interface NotExistsEmail {

	 String message() default "Email already exists!";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
}
