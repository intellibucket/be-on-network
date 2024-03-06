package com.intellibucket.lib.payload.event.reorder;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.event.delete.ContactDeleteEvent;
import com.intellibucket.lib.payload.payload.ContactDeletePayload;
@Event
public class ContactReorderEvent extends AbstractStartDomainEvent<ContactReorderEvent> {
    public ContactReorderEvent(ContactReorderEvent payload) {
        super(payload);
    }
    public static ContactReorderEvent of(ContactReorderEvent payload){
        return new ContactReorderEvent(payload);
    }
}
