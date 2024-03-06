package com.intellibucket.lib.event.create.companyprofile;

import com.intellibucket.lib.payload.companyprofile.CompanyProfileCreatedPayload;
import com.intellibucket.lib.payload.companyprofile.CompanyProfileDeletedPayload;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

public class CompanyProfileCreatedEvent extends AbstractSuccessDomainEvent<CompanyProfileCreatedPayload> {
    public CompanyProfileCreatedEvent(CompanyProfileCreatedPayload payload) {
        super(payload);
    }

    public static CompanyProfileCreatedEvent of(CompanyProfileCreatedPayload payload) {
        return new CompanyProfileCreatedEvent(payload);
    }
}
