package az.rock.auth.domain.presentation.exception;

public class AuthDomainPresentationException extends RuntimeException {
    public AuthDomainPresentationException(String message) {
        super(message);
    }

    public AuthDomainPresentationException() {}
}
