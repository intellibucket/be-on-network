package com.intellibukcet.lib.payload.event.abstracts;

import com.intellibukcet.lib.payload.event.EventType;

public class AbstractFailDomainEvent <R> extends AbstractDomainEvent<R> {

    protected AbstractFailDomainEvent(R payload) {
        super(payload);
    }

    @Override
    public String getEventType() {
        return EventType.FAIL.name();
    }
}