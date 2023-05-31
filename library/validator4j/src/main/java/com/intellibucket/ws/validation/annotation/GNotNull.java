package com.intellibucket.ws.validation.annotation;

import com.intellibucket.ws.validation.concretes.EmailValidator;
import com.intellibucket.ws.validation.concretes.NotNullValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotNullValidator.class)
@Target( {  ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface GNotNull {
    String message() default "Value cannot be null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
