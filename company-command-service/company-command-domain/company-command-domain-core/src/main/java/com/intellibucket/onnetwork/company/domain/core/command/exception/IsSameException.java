package com.intellibucket.onnetwork.company.domain.core.command.exception;

import az.rock.lib.jexception.JRuntimeException;

public class IsSameException  extends JRuntimeException {
    public IsSameException(String message) {
        super(message);
    }
}
