package az.rock.auth.domain.presentation.validation.concretes;

import az.rock.auth.domain.presentation.exception.AuthValidationException;
import az.rock.auth.domain.presentation.validation.annotation.GEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

public class EmailValidator implements ConstraintValidator<GEmail, String>{
    @Override
    public void initialize(GEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    @SneakyThrows(AuthValidationException.class)
    public boolean isValid(String value, ConstraintValidatorContext context) {
        throw new AuthValidationException("Email validation is not implemented yet.");
    }
}
