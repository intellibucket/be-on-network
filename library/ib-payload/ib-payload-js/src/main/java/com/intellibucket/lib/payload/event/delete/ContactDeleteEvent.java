package com.intellibucket.lib.payload.event.delete;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.event.update.ContactUpdateEvent;
import com.intellibucket.lib.payload.payload.ContactDeletePayload;
import com.intellibucket.lib.payload.payload.ContactPayload;

import java.util.UUID;

@Event
public class ContactDeleteEvent extends AbstractStartDomainEvent<ContactDeletePayload> {
    public ContactDeleteEvent(ContactDeletePayload payload) {
        super(payload);
    }
    public static ContactDeleteEvent of(ContactDeletePayload payload){
        return new ContactDeleteEvent(payload);
    }


}
