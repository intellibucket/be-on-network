package com.intellibucket.lib.payload.event.update.number;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;

import java.util.UUID;

public class PhoneNumberDeletedEvent extends AbstractStartDomainEvent<UUID> {
    public PhoneNumberDeletedEvent() {
    }

    private PhoneNumberDeletedEvent(UUID root) {
        super(root);
    }

    public static PhoneNumberDeletedEvent of(UUID root) {
        return new PhoneNumberDeletedEvent(root);
    }
}
