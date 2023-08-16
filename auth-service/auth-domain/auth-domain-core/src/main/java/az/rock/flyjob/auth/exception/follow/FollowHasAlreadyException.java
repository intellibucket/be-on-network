package az.rock.flyjob.auth.exception.follow;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class FollowHasAlreadyException extends AuthDomainException {

    public FollowHasAlreadyException() {
        super("F0000000031");
    }
}
