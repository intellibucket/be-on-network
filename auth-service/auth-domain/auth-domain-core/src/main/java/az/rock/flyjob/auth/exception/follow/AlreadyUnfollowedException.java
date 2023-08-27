package az.rock.flyjob.auth.exception.follow;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class AlreadyUnfollowedException extends AuthDomainException {
    public AlreadyUnfollowedException(String message) {
        super(message);
    }
}
