package com.intellibucket.ws.validation.concretes;

import com.intellibucket.ws.exception.ValidationException;
import com.intellibucket.ws.validation.annotation.GEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<GEmail, String>{
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Override
    public void initialize(GEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    @SneakyThrows(ValidationException.class)
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) throw new ValidationException("Invalid email");
        return true;
    }
}
