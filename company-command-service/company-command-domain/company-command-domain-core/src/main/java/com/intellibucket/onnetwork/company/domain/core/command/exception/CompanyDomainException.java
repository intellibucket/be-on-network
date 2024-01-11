package com.intellibucket.onnetwork.company.domain.core.command.exception;

import az.rock.lib.jexception.JDomainException;

public class CompanyDomainException extends JDomainException {
    public CompanyDomainException(String message) {
        super(message);
    }
}
