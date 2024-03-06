package com.intellibucket.onnetwork.company.domain.core.command.exception;

import az.rock.lib.jexception.JRuntimeException;

public class EntityMatchException extends JRuntimeException {
    public EntityMatchException(String message) {
        super(message);
    }
}
