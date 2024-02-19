package com.intellibucket.onnetwork.company.domain.presentation.command.exception;

public class EmailDomainException extends RuntimeException {
    public EmailDomainException(String message) {
        super(message);
    }

    public EmailDomainException() {}
}

