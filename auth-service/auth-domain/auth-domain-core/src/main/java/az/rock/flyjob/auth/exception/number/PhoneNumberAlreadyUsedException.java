package az.rock.flyjob.auth.exception.number;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class PhoneNumberAlreadyUsedException extends AuthDomainException {
    public PhoneNumberAlreadyUsedException() {
        super("F0000000046");
    }
}
