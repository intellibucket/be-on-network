package az.rock.auth.domain.presentation.validation.concretes;

import az.rock.auth.domain.presentation.exception.AuthValidationException;
import az.rock.auth.domain.presentation.validation.annotation.GEmail;
import az.rock.auth.domain.presentation.validation.annotation.GPattern;
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
    @SneakyThrows(AuthValidationException.class)
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(this.pattern);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) throw new AuthValidationException("Invalid password");
        return true;
    }
}
