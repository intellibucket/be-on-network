package com.intellibucket.ws.validation.annotation;

import com.intellibucket.ws.validation.concretes.StringValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringValueValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface GStringValue {
    String message() default "Invalid string value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String absoluteName();
    String pattern() default "";
    int min() default 0;
    int max() default 50;

}
