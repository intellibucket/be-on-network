package com.intellibucket.onnetwork.company.domain.core.command.exception.email;


import az.rock.lib.jexception.JRuntimeException;

public class EmailNotFoundException extends JRuntimeException {
    public EmailNotFoundException() {
        super("F0000000011");
    }
}
