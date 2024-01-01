package com.intellibucket.lib.payload.event.create.user;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;

@Event
public class CompanyCreatedEvent extends AbstractStartDomainEvent<CompanyRegistrationPayload> {
    public CompanyCreatedEvent() {
    }

    protected CompanyCreatedEvent(CompanyRegistrationPayload root) {
        super(root);
    }

    public static CompanyCreatedEvent of(CompanyRegistrationPayload root) {
        return new CompanyCreatedEvent(root);
    }
}
