package com.intellibukcet.lib.payload.event.concretes;

import com.intellibukcet.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibukcet.lib.payload.payload.FailPayload;

import java.util.List;

public class FailDomainEvent extends AbstractFailDomainEvent<FailPayload> {
    protected FailDomainEvent(FailPayload payload) {
        super(payload);
    }

    public static FailDomainEvent of(List<String> message) {
        return new FailDomainEvent(new FailPayload(message));
    }

    public static FailDomainEvent of(String message) {
        return new FailDomainEvent(new FailPayload(message));
    }
}
