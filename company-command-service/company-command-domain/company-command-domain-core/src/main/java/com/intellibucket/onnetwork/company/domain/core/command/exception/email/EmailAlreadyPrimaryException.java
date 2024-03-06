package com.intellibucket.onnetwork.company.domain.core.command.exception.email;

import az.rock.lib.jexception.JRuntimeException;

public class EmailAlreadyPrimaryException extends JRuntimeException {
    public EmailAlreadyPrimaryException() {
        super("F0000000008");
    }
}