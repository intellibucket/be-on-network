package az.rock.flyjob.auth.exception.number;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class PhoneNumberAlreadyExistException extends AuthDomainException {
    public PhoneNumberAlreadyExistException() {
        super("F0000000044");
    }
}
