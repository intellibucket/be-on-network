package az.rock.flyjob.auth.exception.password;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class SamePasswordOnChangeException extends AuthDomainException {
    public SamePasswordOnChangeException() {
        super("F0000000052");
    }
}
