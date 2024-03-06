package az.rock.flyjob.auth.exception.number;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class PhoneNumberNotFoundException extends AuthDomainException {
    public PhoneNumberNotFoundException() {
        super("F0000000050");
    }
}
