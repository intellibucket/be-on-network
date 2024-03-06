package com.intellibucket.onnetwork.company.dataAccess.command.exception;

import az.rock.lib.jexception.JException;

public class VacancyCommandDataAccessException extends JException {
    public VacancyCommandDataAccessException(String code) {
        super(code);
    }

    public VacancyCommandDataAccessException() {
        super("F0000000001");
    }
}
