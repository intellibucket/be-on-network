package az.rock.flyjob.auth.exception.block;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class UserAlreadyBlockedException extends AuthDomainException {
    public UserAlreadyBlockedException() {
        super("F0000000031");
    }
}

