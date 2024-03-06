package com.intellibucket.lib.event.create.website;

import com.intellibucket.lib.event.create.companyprofile.CompanyProfileUpdatedEvent;
import com.intellibucket.lib.payload.companyprofile.CompanyProfileCreatedPayload;
import com.intellibucket.lib.payload.companyprofile.CompanyProfileUpdatedPayload;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.website.CompanyWebsiteCreatedPayload;

public class CompanyWebsiteCreatedEvent extends AbstractSuccessDomainEvent<CompanyWebsiteCreatedPayload> {
    public CompanyWebsiteCreatedEvent(CompanyWebsiteCreatedPayload payload) {
        super(payload);
    }

    public static CompanyWebsiteCreatedEvent of(CompanyWebsiteCreatedPayload payload) {
        return new CompanyWebsiteCreatedEvent(payload);
    }
}
