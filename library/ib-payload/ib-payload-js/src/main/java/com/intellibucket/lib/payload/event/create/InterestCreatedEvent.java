package com.intellibucket.lib.payload.event.create;


import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.InterestCreatedPayload;

@Event
public class InterestCreatedEvent extends AbstractStartDomainEvent<InterestCreatedPayload> {
    protected InterestCreatedEvent(InterestCreatedPayload payload) {
        super(payload);
    }

    public static InterestCreatedEvent of(InterestCreatedPayload payload) {
        return new InterestCreatedEvent(payload);
    }
}
