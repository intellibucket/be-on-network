package com.intellibucket.lib.payload.companyprofile;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class CompanyProfileUpdatedPayload extends Payload {
    private UUID id;

    public CompanyProfileUpdatedPayload() {
        super();
    }

    public CompanyProfileUpdatedPayload(UUID id) {
        super();
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
