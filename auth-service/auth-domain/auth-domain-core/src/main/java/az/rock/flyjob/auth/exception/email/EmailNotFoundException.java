package az.rock.flyjob.auth.exception.email;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class EmailNotFoundException extends AuthDomainException {
    public EmailNotFoundException() {
        super("F0000000011");
    }
}
