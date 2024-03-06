package com.intellibucket.onnetwork.company.domain.presentation.command.exception;

public class CompanyCommandDomainException extends Exception {
    public CompanyCommandDomainException(String code) {
        super(code);
    }

    public CompanyCommandDomainException() {
        super("F0000000001");
    }
}
