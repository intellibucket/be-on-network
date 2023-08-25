package com.intellibukcet.lib.payload.event.concretes;

import com.intellibukcet.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibukcet.lib.payload.payload.Payload;

public class SuccessDomainEvent <P extends Payload> extends AbstractSuccessDomainEvent<P> {
    protected SuccessDomainEvent(P payload) {
        super(payload);
    }
}