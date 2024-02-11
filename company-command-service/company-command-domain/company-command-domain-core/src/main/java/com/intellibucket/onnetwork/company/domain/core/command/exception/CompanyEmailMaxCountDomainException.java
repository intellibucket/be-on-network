package com.intellibucket.onnetwork.company.domain.core.command.exception;

import az.rock.lib.jexception.JDomainException;
import az.rock.lib.jexception.JRuntimeException;

public class CompanyEmailMaxCountDomainException extends JRuntimeException {
    public CompanyEmailMaxCountDomainException() {
        super("F0000000004");
    }
}
