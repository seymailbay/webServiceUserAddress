package com.springmp.springmp.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {UniqueUserNameValidator.class})
public @interface UniqueUserName {

    String message() default "{backend.constraints.UniqueUserName.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
