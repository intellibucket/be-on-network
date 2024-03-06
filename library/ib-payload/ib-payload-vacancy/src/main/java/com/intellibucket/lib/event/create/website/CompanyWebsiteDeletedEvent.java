package com.intellibucket.lib.event.create.website;

import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.website.CompanyWebsiteDeletedPayload;
import com.intellibucket.lib.payload.website.CompanyWebsiteUpdatedPayload;

public class CompanyWebsiteDeletedEvent extends AbstractSuccessDomainEvent<CompanyWebsiteDeletedPayload> {
    public CompanyWebsiteDeletedEvent(CompanyWebsiteDeletedPayload payload) {
        super(payload);
    }

    public static CompanyWebsiteDeletedEvent of(CompanyWebsiteDeletedPayload payload) {
        return new CompanyWebsiteDeletedEvent(payload);
    }
}
