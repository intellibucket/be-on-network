package az.rock.flyjob.auth.exception.user;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class UserProfileNotFoundException extends AuthDomainException {
    public UserProfileNotFoundException() {
        super("F0000000053");
    }

    public UserProfileNotFoundException(String message) {
        super(message);
    }
}
