package com.intellibucket.onnetwork.company.domain.core.command.exception;

import az.rock.lib.jexception.JRuntimeException;

public class FoundMoreThanOneActiveRow extends JRuntimeException {
    public FoundMoreThanOneActiveRow(String message) {
        super(message);
    }
}
