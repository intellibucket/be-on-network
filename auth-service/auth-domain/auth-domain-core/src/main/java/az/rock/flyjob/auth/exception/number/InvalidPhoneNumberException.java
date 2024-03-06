package az.rock.flyjob.auth.exception.number;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class InvalidPhoneNumberException extends AuthDomainException {
    public InvalidPhoneNumberException() {
        super("F0000000045");
    }
}
