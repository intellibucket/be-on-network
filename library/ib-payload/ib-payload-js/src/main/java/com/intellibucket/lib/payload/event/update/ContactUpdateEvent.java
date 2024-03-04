package com.intellibucket.lib.payload.event.update;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.create.ContactCreatedEvent;
import com.intellibucket.lib.payload.payload.ContactPayload;

public class ContactUpdateEvent extends AbstractStartDomainEvent<ContactPayload> {
    public ContactUpdateEvent(ContactPayload payload) {
        super(payload);
    }
    public static ContactUpdateEvent of(ContactPayload payload){
        return new ContactUpdateEvent(payload);
    }


}
