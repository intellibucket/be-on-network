package com.intellibucket.onnetwork.company.domain.core.command.exception.email;

import az.rock.lib.jexception.JRuntimeException;

public class EmailAlreadyExistException extends JRuntimeException {
    public EmailAlreadyExistException() {
        super("F0000000006");
    }
}