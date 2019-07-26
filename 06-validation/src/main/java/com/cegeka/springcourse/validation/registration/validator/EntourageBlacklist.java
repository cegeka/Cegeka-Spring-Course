package com.cegeka.springcourse.validation.registration.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = EntourageBlacklistValidator.class)
@Documented
public @interface EntourageBlacklist {

    String message() default "{entourage.invalid.blacklist}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
