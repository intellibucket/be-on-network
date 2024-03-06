package com.intellibucket.ws.exception;

import jakarta.validation.ValidationException;

public class GValidationException extends ValidationException {
    public GValidationException(String code) {
        super(code);
    }
}
