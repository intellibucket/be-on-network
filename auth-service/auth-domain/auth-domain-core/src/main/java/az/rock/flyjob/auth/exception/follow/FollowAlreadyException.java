package az.rock.flyjob.auth.exception.follow;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class FollowAlreadyException extends AuthDomainException {

    public FollowAlreadyException() {
        super("F0000000031");
    }
}
