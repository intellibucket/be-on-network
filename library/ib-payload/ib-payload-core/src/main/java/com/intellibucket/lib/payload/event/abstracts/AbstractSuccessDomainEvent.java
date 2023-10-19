package com.intellibucket.lib.payload.event.abstracts;

import com.intellibucket.lib.payload.event.EventType;

public class AbstractSuccessDomainEvent <R> extends AbstractDomainEvent<R> {

    protected AbstractSuccessDomainEvent(R payload) {
        super(payload);
    }

    @Override
    public String getEventType() {
        return EventType.SUCCESS.name();
    }
}