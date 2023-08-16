package com.intellibucket.ws.validation.concretes;

import com.intellibucket.ws.exception.GValidationException;
import com.intellibucket.ws.validation.annotation.GPattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidator implements ConstraintValidator<GPattern, String>{
    private String pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,}$";

    private String messageCode;

    @Override
    public void initialize(GPattern constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
        this.messageCode = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!Objects.isNull(value)){
            Pattern pattern = Pattern.compile(this.pattern);
            Matcher matcher = pattern.matcher(value);
            if (!matcher.find()) throw new GValidationException(this.messageCode);
            return true;
        }else {
            throw new GValidationException(this.messageCode);
        }
    }
}
