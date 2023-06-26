package az.rock.auth.domain.presentation.exception;

public class EmailDomainException extends RuntimeException {
    public EmailDomainException(String message) {
        super(message);
    }

    public EmailDomainException() {}
}

