package com.intellibukcet.lib.payload.event.abstracts;

import com.intellibukcet.lib.payload.event.EventType;

public class AbstractSuccessDomainEvent <R> extends AbstractDomainEvent<R> {

    protected AbstractSuccessDomainEvent(R payload) {
        super(payload);
    }

    @Override
    public String getEventType() {
        return EventType.SUCCESS.name();
    }
}