package az.rock.flyjob.auth.exception.email;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class EmailAlreadyExistException extends AuthDomainException {
    public EmailAlreadyExistException() {
        super("F0000000012");
    }
}
