package com.intellibucket.lib.payload.event.create;


import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.InterestCreatedPayload;

@Event
public class InterestCreateEvent extends AbstractStartDomainEvent<InterestCreatedPayload> {
    protected InterestCreateEvent(InterestCreatedPayload payload) {
        super(payload);
    }

    public static InterestCreateEvent of(InterestCreatedPayload payload) {
        return new InterestCreateEvent(payload);
    }
}
