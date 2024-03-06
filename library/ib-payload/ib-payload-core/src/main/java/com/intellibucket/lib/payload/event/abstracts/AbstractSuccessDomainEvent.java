package com.intellibucket.lib.payload.event.abstracts;

import com.intellibucket.lib.payload.event.EventType;

public class AbstractSuccessDomainEvent<R> extends AbstractDomainEvent<R> {

    public AbstractSuccessDomainEvent() {
        this(null);
    }

    protected AbstractSuccessDomainEvent(R payload) {
        super(payload);
        this.eventType = EventType.SUCCESS;
    }

}