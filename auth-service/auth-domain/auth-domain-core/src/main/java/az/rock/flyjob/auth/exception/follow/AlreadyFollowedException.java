package az.rock.flyjob.auth.exception.follow;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class AlreadyFollowedException extends AuthDomainException {

    public AlreadyFollowedException() {
        super("F0000000031");
    }
}
