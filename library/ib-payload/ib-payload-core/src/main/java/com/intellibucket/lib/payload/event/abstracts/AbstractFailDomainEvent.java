package com.intellibucket.lib.payload.event.abstracts;

import com.intellibucket.lib.payload.event.EventType;

public class AbstractFailDomainEvent<R> extends AbstractDomainEvent<R> {

    public AbstractFailDomainEvent() {
        this(null);
    }

    protected AbstractFailDomainEvent(R payload) {
        super(payload);
        this.eventType = EventType.FAIL;
    }

}