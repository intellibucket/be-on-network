package az.rock.auth.domain.presentation.exception;

public class AuthDomainException extends RuntimeException {
    public AuthDomainException(String message) {
        super(message);
    }

    public AuthDomainException() {}
}
