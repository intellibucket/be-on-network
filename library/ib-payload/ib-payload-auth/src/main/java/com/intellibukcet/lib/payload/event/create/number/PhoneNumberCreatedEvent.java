package com.intellibukcet.lib.payload.event.create.number;

import com.intellibukcet.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;
import com.intellibukcet.lib.payload.payload.PhoneNumberPayload;

@Event
public class PhoneNumberCreatedEvent extends AbstractStartDomainEvent<PhoneNumberPayload> {
    private PhoneNumberCreatedEvent(PhoneNumberPayload root) {
        super(root);
    }

    public static PhoneNumberCreatedEvent of(PhoneNumberPayload root) {
        return new PhoneNumberCreatedEvent(root);
    }
}

