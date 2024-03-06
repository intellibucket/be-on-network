package com.intellibucket.lib.event.create.email;

import com.intellibucket.lib.payload.email.CompanyEmailDeletedPayload;
import com.intellibucket.lib.payload.email.CompanyEmailUpdatedPayload;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

public class CompanyEmailDeletedEvent extends AbstractSuccessDomainEvent<CompanyEmailDeletedPayload> {
    public CompanyEmailDeletedEvent(CompanyEmailDeletedPayload payload) {
        super(payload);
    }

    public static CompanyEmailDeletedEvent of(CompanyEmailDeletedPayload payload) {
        return new CompanyEmailDeletedEvent(payload);
    }


}