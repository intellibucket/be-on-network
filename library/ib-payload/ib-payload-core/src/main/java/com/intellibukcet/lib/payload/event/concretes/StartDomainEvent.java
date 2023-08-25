package com.intellibukcet.lib.payload.event.concretes;

import com.intellibukcet.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibukcet.lib.payload.payload.Payload;

public class StartDomainEvent<P extends Payload> extends AbstractStartDomainEvent<P> {
    protected StartDomainEvent(P payload) {
        super(payload);
    }
}
