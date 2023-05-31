package com.intellibucket.ws.validation.concretes;

import com.intellibucket.ws.exception.ValidationException;
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
    @SneakyThrows(ValidationException.class)
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) throw new ValidationException("Value cannot be null");
        return true;
    }
}