package com.intellibukcet.lib.payload.event.create.user;

import com.intellibukcet.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;
import com.intellibukcet.lib.payload.payload.reg.CompanyRegistrationPayload;

@Event
public class CompanyCreatedEvent extends AbstractStartDomainEvent<CompanyRegistrationPayload> {
    protected CompanyCreatedEvent(CompanyRegistrationPayload root) {
        super(root);
    }

    public static CompanyCreatedEvent of(CompanyRegistrationPayload root) {
        return new CompanyCreatedEvent(root);
    }
}
