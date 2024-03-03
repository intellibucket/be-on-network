package com.intellibucket.onnetwork.company.domain.core.command.exception;

import az.rock.lib.jexception.JRuntimeException;

public class MultipleActiveRowsException extends JRuntimeException {
    public MultipleActiveRowsException(String message) {
        super(message);
    }
}
