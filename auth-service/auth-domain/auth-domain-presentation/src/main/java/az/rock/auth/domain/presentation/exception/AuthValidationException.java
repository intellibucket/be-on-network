package az.rock.auth.domain.presentation.exception;

public class AuthValidationException extends Exception{
    public AuthValidationException(String message) {
        super(message);
    }

    public AuthValidationException() {}
}
