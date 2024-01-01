package com.intellibucket.lib.payload.event.abstracts;

import com.intellibucket.lib.payload.event.EventType;

public abstract class AbstractStartDomainEvent<R> extends AbstractDomainEvent<R> {
    protected AbstractStartDomainEvent(R root) {
        super(root);
    }

    public AbstractStartDomainEvent() {
        this.eventType = EventType.START;
    }


    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "root=" + super.getPayload() +
                '}';
    }
}
