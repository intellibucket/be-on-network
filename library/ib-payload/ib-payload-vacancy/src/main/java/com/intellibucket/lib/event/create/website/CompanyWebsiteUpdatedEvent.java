package com.intellibucket.lib.event.create.website;

import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.website.CompanyWebsiteCreatedPayload;
import com.intellibucket.lib.payload.website.CompanyWebsiteUpdatedPayload;

public class CompanyWebsiteUpdatedEvent extends AbstractSuccessDomainEvent<CompanyWebsiteUpdatedPayload> {
    public CompanyWebsiteUpdatedEvent(CompanyWebsiteUpdatedPayload payload) {
        super(payload);
    }

    public static CompanyWebsiteUpdatedEvent of(CompanyWebsiteUpdatedPayload payload) {
        return new CompanyWebsiteUpdatedEvent(payload);
    }
}
