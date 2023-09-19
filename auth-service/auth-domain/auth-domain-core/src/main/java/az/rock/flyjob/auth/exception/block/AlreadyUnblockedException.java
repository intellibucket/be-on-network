package az.rock.flyjob.auth.exception.block;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class AlreadyUnblockedException extends AuthDomainException {

    public AlreadyUnblockedException() {
        super("F0000000038");
    }
}
