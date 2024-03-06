package az.rock.flyjob.auth.exception.follow;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class FollowSelfTrackingException extends AuthDomainException {
    public FollowSelfTrackingException() {
        super("F0000000033");
    }
}
