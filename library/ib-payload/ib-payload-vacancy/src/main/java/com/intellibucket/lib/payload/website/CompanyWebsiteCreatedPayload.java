package com.intellibucket.lib.payload.website;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class CompanyWebsiteCreatedPayload extends Payload {
    private UUID id;

    public CompanyWebsiteCreatedPayload() {
        super();
    }

    public CompanyWebsiteCreatedPayload(UUID id) {
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
