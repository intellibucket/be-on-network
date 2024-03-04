package com.intellibucket.lib.payload.event.delete;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.update.ContactUpdateEvent;
import com.intellibucket.lib.payload.payload.ContactPayload;

public class ContactDeleteEvent extends AbstractStartDomainEvent<ContactPayload> {
    public ContactDeleteEvent(ContactPayload payload) {
        super(payload);
    }
    public static ContactDeleteEvent of(ContactPayload payload){
        return new ContactDeleteEvent(payload);
    }


}
