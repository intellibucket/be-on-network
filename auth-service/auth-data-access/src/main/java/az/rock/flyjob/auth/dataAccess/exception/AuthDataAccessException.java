package az.rock.flyjob.auth.dataAccess.exception;

import az.rock.lib.jexception.JException;

public class AuthDataAccessException extends RuntimeException {
    public AuthDataAccessException(String message) {
        super(message);
    }
}
