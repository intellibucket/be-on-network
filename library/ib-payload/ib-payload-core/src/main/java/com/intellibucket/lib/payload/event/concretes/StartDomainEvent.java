package com.intellibucket.lib.payload.event.concretes;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;

public class StartDomainEvent<P extends Payload> extends AbstractStartDomainEvent<P> {
    protected StartDomainEvent(P payload) {
        super(payload);
    }
}
