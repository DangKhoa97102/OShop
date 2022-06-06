package com.oshop.validator.annotation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.oshop.validator.ExistsEmailValidator;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ExistsEmailValidator.class)
@Documented
public @interface ExistsEmail {
	String message() default "Email does not exist!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
