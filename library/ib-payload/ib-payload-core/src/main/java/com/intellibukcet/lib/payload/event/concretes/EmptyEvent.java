package com.intellibukcet.lib.payload.event.concretes;

import com.intellibukcet.lib.payload.event.abstracts.DomainEvent;

public final class EmptyEvent implements DomainEvent<Void> {
    public static final EmptyEvent INSTANCE = new EmptyEvent();

    private EmptyEvent() {}

    @Override
    public void fire() {

    }
}
