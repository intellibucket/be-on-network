package com.intellibukcet.lib.payload.event.update.number;

import com.intellibukcet.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibukcet.lib.payload.payload.PhoneNumberPayload;

public class PhoneNumberUpdatedEvent extends AbstractStartDomainEvent<PhoneNumberPayload> {
    private PhoneNumberUpdatedEvent(PhoneNumberPayload root) {
        super(root);
    }

    public static PhoneNumberUpdatedEvent of(PhoneNumberPayload root) {
        return new PhoneNumberUpdatedEvent(root);
    }
}
