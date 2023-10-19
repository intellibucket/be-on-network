package com.intellibucket.lib.payload.event.concretes;

import com.intellibucket.lib.payload.event.abstracts.DomainEvent;

public final class EmptyEvent implements DomainEvent<Void> {
    public static final EmptyEvent INSTANCE = new EmptyEvent();

    private EmptyEvent() {}

    @Override
    public void fire() {

    }
}
