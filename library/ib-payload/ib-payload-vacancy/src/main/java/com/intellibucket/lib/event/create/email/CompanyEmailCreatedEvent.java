package com.intellibucket.lib.event.create.email;

import com.intellibucket.lib.payload.email.CompanyEmailCreatedPayload;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

public class CompanyEmailCreatedEvent extends AbstractSuccessDomainEvent<CompanyEmailCreatedPayload> {
    public CompanyEmailCreatedEvent(CompanyEmailCreatedPayload payload) {
        super(payload);
    }

    public static CompanyEmailCreatedEvent of(CompanyEmailCreatedPayload payload) {
        return new CompanyEmailCreatedEvent(payload);
    }


}
