package az.rock.flyjob.auth.exception.block;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class AlreadyBlockedException extends AuthDomainException {

    public AlreadyBlockedException() {
        super("F0000000035");
    }

}
