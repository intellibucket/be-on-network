package com.intellibucket.lib.payload.event.abstracts;

public class AbstractFailDomainEvent <R> extends AbstractDomainEvent<R> {

    protected AbstractFailDomainEvent(R payload) {
        super(payload);
    }

}