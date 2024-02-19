package com.intellibucket.onnetwork.company.domain.core.command.exception.email;

import az.rock.lib.jexception.JRuntimeException;

public class CompanyEmailMaxCountException extends JRuntimeException {
    public CompanyEmailMaxCountException() {
        super("F0000000004");
    }
}
