package com.intellibucket.lib.event.create;

import com.intellibucket.lib.event.create.email.CompanyEmailUpdatedEvent;
import com.intellibucket.lib.payload.CompanyFilledPayload;
import com.intellibucket.lib.payload.companyprofile.CompanyProfileCreatedPayload;
import com.intellibucket.lib.payload.email.CompanyEmailUpdatedPayload;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

public class CompanyFilledEvent extends AbstractSuccessDomainEvent<CompanyFilledPayload> {
    public CompanyFilledEvent(CompanyFilledPayload payload) {
        super(payload);
    }

    public static CompanyFilledEvent of(CompanyFilledPayload payload) {
        return new CompanyFilledEvent(payload);
    }

}
