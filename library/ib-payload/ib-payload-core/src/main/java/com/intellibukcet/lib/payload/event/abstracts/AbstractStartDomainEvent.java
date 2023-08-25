package com.intellibukcet.lib.payload.event.abstracts;

import com.intellibukcet.lib.payload.event.EventType;

public abstract class AbstractStartDomainEvent<R> extends AbstractDomainEvent<R> {
    protected AbstractStartDomainEvent(R root) {
        super(root);
    }

    public AbstractStartDomainEvent(){}

    @Override
    public String getEventType() {
        return EventType.START.name();
    }
}
