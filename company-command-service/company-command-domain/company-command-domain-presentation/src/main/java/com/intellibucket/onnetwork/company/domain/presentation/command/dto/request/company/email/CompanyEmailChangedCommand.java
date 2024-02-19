package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email;

import java.util.UUID;

public class CompanyEmailChangedCommand {

    private final String email;
    private final UUID emailUUID;

    public CompanyEmailChangedCommand(String email, UUID emailUUID) {
        this.email = email;

        this.emailUUID = emailUUID;
    }

    public String getEmail() {
        return email;
    }

    public UUID getEmailUUID() {
        return emailUUID;
    }
}
