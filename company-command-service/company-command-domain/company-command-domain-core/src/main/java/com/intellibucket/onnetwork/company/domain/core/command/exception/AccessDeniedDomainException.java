package com.intellibucket.onnetwork.company.domain.core.command.exception;

import az.rock.lib.jexception.JDomainException;
import az.rock.lib.jexception.JRuntimeException;

public class AccessDeniedDomainException extends JRuntimeException {
    public AccessDeniedDomainException() {
        super("F0000000007");
    }
}
