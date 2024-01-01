package com.intellibucket.lib.payload.event.abstracts;

public class AbstractSuccessDomainEvent<R> extends AbstractDomainEvent<R> {

    public AbstractSuccessDomainEvent() {
    }

    protected AbstractSuccessDomainEvent(R payload) {
        super(payload);
    }
}