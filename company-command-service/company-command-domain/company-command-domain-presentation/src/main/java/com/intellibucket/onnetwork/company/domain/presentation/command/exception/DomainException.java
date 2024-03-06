package com.intellibucket.onnetwork.company.domain.presentation.command.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }

    public DomainException() {}
}

