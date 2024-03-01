package com.intellibucket.lib.event.create.companyprofile;

import com.intellibucket.lib.payload.CompanyProfileCreatedPayload;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

public class CompanyProfileCreatedEvent extends AbstractSuccessDomainEvent<CompanyProfileCreatedPayload> {
    public CompanyProfileCreatedEvent(CompanyProfileCreatedPayload payload) {
        super(payload);
    }


}
