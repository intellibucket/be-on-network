package com.intellibucket.ws.validation.concretes;

import com.intellibucket.ws.exception.GValidationException;
import com.intellibucket.ws.validation.annotation.GNotNull;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

public class NotNullValidator implements ConstraintValidator<GNotNull, Object> {

    @Override
    public void initialize(GNotNull constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    @SneakyThrows(GValidationException.class)
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) throw new GValidationException("Value cannot be null");
        return true;
    }
}