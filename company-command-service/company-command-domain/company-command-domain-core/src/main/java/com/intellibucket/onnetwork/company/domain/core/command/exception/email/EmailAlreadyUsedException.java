package com.intellibucket.onnetwork.company.domain.core.command.exception.email;

import az.rock.lib.jexception.JRuntimeException;

public class EmailAlreadyUsedException extends JRuntimeException {
    public EmailAlreadyUsedException() {
        super("F0000000006");
    }
}