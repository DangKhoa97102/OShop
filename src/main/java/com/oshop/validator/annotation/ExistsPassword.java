package com.oshop.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.oshop.validator.ExistsPasswordValidator;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ExistsPasswordValidator.class)
@Documented
public @interface ExistsPassword {

	String message() default "Incorrect password!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
