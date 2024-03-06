package az.rock.flyjob.auth.exception.password;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class IncorrectOldPasswordException extends AuthDomainException {
    public IncorrectOldPasswordException() {
        super("F0000000051");
    }
}
