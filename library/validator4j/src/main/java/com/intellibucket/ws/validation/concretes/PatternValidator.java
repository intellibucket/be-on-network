package com.intellibucket.ws.validation.concretes;

import com.intellibucket.ws.exception.ValidationException;
import com.intellibucket.ws.validation.annotation.GPattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidator implements ConstraintValidator<GPattern, String>{
    private String pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,}$";

    @Override
    public void initialize(GPattern constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    @SneakyThrows(ValidationException.class)
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(this.pattern);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) throw new ValidationException("Value pattern does not match");
        return true;
    }
}
