package com.intellibucket.lib.event.create.companyprofile;

import com.intellibucket.lib.payload.companyprofile.CompanyProfileDeletedPayload;
import com.intellibucket.lib.payload.companyprofile.CompanyProfileUpdatedPayload;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

public class CompanyProfileDeletedEvent extends AbstractSuccessDomainEvent<CompanyProfileDeletedPayload> {
    public CompanyProfileDeletedEvent(CompanyProfileDeletedPayload payload) {
        super(payload);
    }

    public static CompanyProfileDeletedEvent of(CompanyProfileDeletedPayload payload) {
        return new CompanyProfileDeletedEvent(payload);
    }
}