package com.intellibucket.lib.payload.website;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class CompanyWebsiteUpdatedPayload extends Payload {
    private UUID id;

    public CompanyWebsiteUpdatedPayload() {
        super();
    }

    public CompanyWebsiteUpdatedPayload(UUID id) {
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
