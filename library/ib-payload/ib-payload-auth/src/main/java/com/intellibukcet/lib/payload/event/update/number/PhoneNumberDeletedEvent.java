package com.intellibukcet.lib.payload.event.update.number;

import com.intellibukcet.lib.payload.event.abstracts.AbstractStartDomainEvent;

import java.util.UUID;

public class PhoneNumberDeletedEvent extends AbstractStartDomainEvent<UUID> {
    private PhoneNumberDeletedEvent(UUID root) {
        super(root);
    }

    public static PhoneNumberDeletedEvent of(UUID root) {
        return new PhoneNumberDeletedEvent(root);
    }
}
