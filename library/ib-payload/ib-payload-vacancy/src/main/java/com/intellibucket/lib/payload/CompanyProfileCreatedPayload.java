package com.intellibucket.lib.payload;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class CompanyProfileCreatedPayload extends Payload {
    private UUID id;

    public CompanyProfileCreatedPayload() {
        super();
    }

    public CompanyProfileCreatedPayload(UUID id) {
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
