package az.rock.flyjob.auth.exception.email;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class EmailMaxCountException extends AuthDomainException {
    public EmailMaxCountException() {
        super("F0000000052");
    }
}
