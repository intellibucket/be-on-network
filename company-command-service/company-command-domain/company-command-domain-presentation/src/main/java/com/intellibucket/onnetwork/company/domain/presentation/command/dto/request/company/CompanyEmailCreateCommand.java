package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company;

import az.rock.lib.valueObject.AccessModifier;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CompanyEmailCreateCommand {
    private final String email;

    public CompanyEmailCreateCommand(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


}
