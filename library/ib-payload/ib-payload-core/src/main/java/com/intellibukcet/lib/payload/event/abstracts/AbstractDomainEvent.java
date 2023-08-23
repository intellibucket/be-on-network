package com.intellibukcet.lib.payload.event.abstracts;


public abstract class AbstractDomainEvent<D> implements DomainEvent<D> , JsonTypeReference {
    private D payload;

    protected AbstractDomainEvent(D payload) {
        this.payload = payload;
    }

    public AbstractDomainEvent(){}

    public D getPayload() {
        return payload;
    }

    public void setPayload(D payload) {
        this.payload = payload;
    }
}
