package com.intellibucket.lib.payload.event.abstracts;


import com.intellibucket.lib.payload.event.EventType;

public abstract class AbstractDomainEvent<D> implements DomainEvent<D>, JsonTypeReference {
    protected EventType eventType;
    private D payload;

    protected AbstractDomainEvent(D payload) {
        this.payload = payload;
    }

    public AbstractDomainEvent() {
    }

    public D getPayload() {
        return payload;
    }

    public void setPayload(D payload) {
        this.payload = payload;
    }

    @Override
    public EventType getEventType() {
        return this.eventType;
    }

    @Override
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
