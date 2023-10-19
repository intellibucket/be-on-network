package com.intellibucket.lib.payload.event.concretes;

import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;

public class SuccessDomainEvent <P extends Payload> extends AbstractSuccessDomainEvent<P> {
    protected SuccessDomainEvent(P payload) {
        super(payload);
    }
}