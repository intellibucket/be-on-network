package com.intellibucket.lib.payload.email;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class CompanyEmailUpdatedPayload extends Payload {
    private UUID companyUuid;
    private String email;

    public CompanyEmailUpdatedPayload(UUID companyUuid, String email) {
        this.companyUuid = companyUuid;
        this.email = email;
    }

    public CompanyEmailUpdatedPayload(){}

    public UUID getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(UUID companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CompanyEmailCreatePayload{" +
                "companyUuid=" + companyUuid +
                ", email='" + email + '\'' +
                '}';
    }
}

