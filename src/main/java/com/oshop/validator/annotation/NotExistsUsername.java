package com.oshop.validator.annotation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.oshop.validator.NotExistsUsernameValidator;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = NotExistsUsernameValidator.class)
@Documented
public @interface NotExistsUsername {

	String message() default "Username already exists!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
