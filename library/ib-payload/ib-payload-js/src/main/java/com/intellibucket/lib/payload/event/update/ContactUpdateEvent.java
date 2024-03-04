package com.intellibucket.lib.payload.event.update;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.event.create.ContactCreatedEvent;
import com.intellibucket.lib.payload.payload.ContactPayload;
import com.intellibucket.lib.payload.payload.ContactUpdatePayload;

@Event
public class ContactUpdateEvent extends AbstractStartDomainEvent<ContactUpdatePayload> {
    public ContactUpdateEvent(ContactUpdatePayload payload) {
        super(payload);
    }
    public static ContactUpdateEvent of(ContactUpdatePayload payload){
        return new ContactUpdateEvent(payload);
    }


}
