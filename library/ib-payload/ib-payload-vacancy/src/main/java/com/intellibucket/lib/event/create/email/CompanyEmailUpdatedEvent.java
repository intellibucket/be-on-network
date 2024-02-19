package com.intellibucket.lib.event.create.email;

import com.intellibucket.lib.payload.email.CompanyEmailCreatedPayload;
import com.intellibucket.lib.payload.email.CompanyEmailUpdatedPayload;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

public class CompanyEmailUpdatedEvent extends AbstractSuccessDomainEvent<CompanyEmailUpdatedPayload> {
    public CompanyEmailUpdatedEvent(CompanyEmailUpdatedPayload payload) {
        super(payload);
    }

    public static CompanyEmailUpdatedEvent of(CompanyEmailUpdatedPayload payload) {
        return new CompanyEmailUpdatedEvent(payload);
    }


}
