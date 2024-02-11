package com.intellibucket.onnetwork.company.domain.core.command.exception;

import az.rock.lib.jexception.JRuntimeException;

public class EmailAlreadyExistException extends JRuntimeException {
    public EmailAlreadyExistException() {
        super("F0000000006");
    }
}