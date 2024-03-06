package com.intellibucket.lib.payload.email;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class CompanyEmailDeletedPayload extends Payload {
    private UUID companyUuid;
    private String email;

    public CompanyEmailDeletedPayload(UUID companyUuid, String email) {
        this.companyUuid = companyUuid;
        this.email = email;
    }

    public CompanyEmailDeletedPayload(){}

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

