package az.rock.flyjob.auth.exception.email;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class EmailAlreadyUsedException extends AuthDomainException {
    public EmailAlreadyUsedException() {
        super("F0000000012");
    }
}
