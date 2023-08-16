package com.intellibucket.ws.validation.concretes;

import com.intellibucket.ws.exception.GValidationException;
import com.intellibucket.ws.validation.annotation.GStringValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringValueValidator implements ConstraintValidator<GStringValue, String> {

    private Boolean nullable;
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
        this.nullable  = constraintAnnotation.nullable();
    }

    @Override
    @SneakyThrows(GValidationException.class)
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!this.nullable && Objects.isNull(value)) throw new GValidationException("Value of " + this.absoluteName + " cannot be null");
        if(!this.pattern.isEmpty()){
            Pattern pattern = Pattern.compile(this.pattern);
            Matcher matcher = pattern.matcher(value);
            if (!matcher.find()) throw new GValidationException(this.absoluteName + " is invalid");
        }
        if(value.length() < this.min || value.length() > this.max) throw new GValidationException(this.absoluteName + " length must be between " + this.min + " and " + this.max);
        return true;
    }
}

