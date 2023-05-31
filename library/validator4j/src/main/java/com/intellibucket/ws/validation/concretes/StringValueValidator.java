package com.intellibucket.ws.validation.concretes;

import com.intellibucket.ws.exception.ValidationException;
import com.intellibucket.ws.validation.annotation.GStringValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringValueValidator implements ConstraintValidator<GStringValue, String> {

    private String pattern;
    private String absoluteName;
    private int min;
    private int max;

    @Override
    public void initialize(GStringValue constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern().trim();
        this.absoluteName = constraintAnnotation.absoluteName();
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    @SneakyThrows(ValidationException.class)
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!this.pattern.isEmpty()){
            Pattern pattern = Pattern.compile(this.pattern);
            Matcher matcher = pattern.matcher(value);
            if (!matcher.find()) throw new ValidationException(this.absoluteName + " is invalid");
        }
        if(value.length() < this.min || value.length() > this.max) throw new ValidationException(this.absoluteName + " length must be between " + this.min + " and " + this.max);
        return true;
    }
}

