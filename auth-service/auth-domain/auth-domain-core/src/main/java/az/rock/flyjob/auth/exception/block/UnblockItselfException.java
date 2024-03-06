package az.rock.flyjob.auth.exception.block;

import az.rock.flyjob.auth.exception.AuthDomainException;

public class UnblockItselfException extends AuthDomainException {

    public UnblockItselfException() {
        super("F0000000039");
    }
}
