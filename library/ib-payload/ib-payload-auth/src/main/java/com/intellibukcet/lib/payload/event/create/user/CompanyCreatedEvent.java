package com.intellibukcet.lib.payload.event.create.user;

import az.rock.lib.event.Event;
import az.rock.lib.event.impl.abstracts.AbstractStartDomainEvent;
import az.rock.lib.event.payload.registration.CompanyRegistrationPayload;

@Event
public class CompanyCreatedEvent extends AbstractStartDomainEvent<CompanyRegistrationPayload> {
    protected CompanyCreatedEvent(CompanyRegistrationPayload root) {
        super(root);
    }

    public static CompanyCreatedEvent of(CompanyRegistrationPayload root) {
        return new CompanyCreatedEvent(root);
    }
}
