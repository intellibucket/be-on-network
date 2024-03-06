package com.intellibucket.lib.payload;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class CompanyFilledPayload extends Payload {
    private UUID id;

    public CompanyFilledPayload() {
        super();
    }

    public CompanyFilledPayload(UUID id) {
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
