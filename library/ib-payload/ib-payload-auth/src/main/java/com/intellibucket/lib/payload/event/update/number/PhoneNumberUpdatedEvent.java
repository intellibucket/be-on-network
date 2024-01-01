package com.intellibucket.lib.payload.event.update.number;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.payload.PhoneNumberPayload;

public class PhoneNumberUpdatedEvent extends AbstractStartDomainEvent<PhoneNumberPayload> {
    public PhoneNumberUpdatedEvent() {
    }

    private PhoneNumberUpdatedEvent(PhoneNumberPayload root) {
        super(root);
    }

    public static PhoneNumberUpdatedEvent of(PhoneNumberPayload root) {
        return new PhoneNumberUpdatedEvent(root);
    }
}
