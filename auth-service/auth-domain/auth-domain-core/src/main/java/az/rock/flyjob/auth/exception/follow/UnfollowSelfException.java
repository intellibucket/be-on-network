package az.rock.flyjob.auth.exception.follow;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class UnfollowSelfException extends AuthDomainException {
    public UnfollowSelfException(String message) {
        super(message);
    }
}
