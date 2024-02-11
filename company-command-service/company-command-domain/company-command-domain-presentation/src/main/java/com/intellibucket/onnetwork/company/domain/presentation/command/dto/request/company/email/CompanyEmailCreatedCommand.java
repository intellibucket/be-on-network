package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email;

import java.util.UUID;

public class CompanyEmailCreatedCommand {

    private final String email;

    public CompanyEmailCreatedCommand(String email) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

}
