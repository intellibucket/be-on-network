package com.intellibucket.lib.event.create.companyprofile;

import com.intellibucket.lib.event.create.email.CompanyEmailUpdatedEvent;
import com.intellibucket.lib.payload.CompanyProfileCreatedPayload;
import com.intellibucket.lib.payload.CompanyProfileUpdatedPayload;
import com.intellibucket.lib.payload.email.CompanyEmailUpdatedPayload;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

public class CompanyProfileUpdatedEvent extends AbstractSuccessDomainEvent<CompanyProfileUpdatedPayload> {
    public CompanyProfileUpdatedEvent(CompanyProfileUpdatedPayload payload) {
        super(payload);
    }

    public static CompanyProfileUpdatedEvent of(CompanyProfileUpdatedPayload payload) {
        return new CompanyProfileUpdatedEvent(payload);
    }
}
