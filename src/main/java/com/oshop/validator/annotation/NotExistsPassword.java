package com.oshop.validator.annotation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.oshop.validator.NotExistsPasswordValidator;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = NotExistsPasswordValidator.class)
@Documented
public @interface NotExistsPassword {

	String message() default "Recently used password!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
