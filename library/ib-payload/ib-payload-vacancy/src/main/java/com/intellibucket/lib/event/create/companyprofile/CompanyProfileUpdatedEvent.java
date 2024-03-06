package com.intellibucket.lib.event.create.companyprofile;

import com.intellibucket.lib.payload.companyprofile.CompanyProfileUpdatedPayload;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

public class CompanyProfileUpdatedEvent extends AbstractSuccessDomainEvent<CompanyProfileUpdatedPayload> {
    public CompanyProfileUpdatedEvent(CompanyProfileUpdatedPayload payload) {
        super(payload);
    }

    public static CompanyProfileUpdatedEvent of(CompanyProfileUpdatedPayload payload) {
        return new CompanyProfileUpdatedEvent(payload);
    }
}
