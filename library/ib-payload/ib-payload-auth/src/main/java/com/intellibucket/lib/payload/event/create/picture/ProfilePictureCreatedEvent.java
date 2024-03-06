package com.intellibucket.lib.payload.event.create.picture;


import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.picture.PicturePayload;

@Event
public class ProfilePictureCreatedEvent extends AbstractStartDomainEvent<PicturePayload> {
    public ProfilePictureCreatedEvent() {
    }

    protected ProfilePictureCreatedEvent(PicturePayload root) {
        super(root);
    }

    public static ProfilePictureCreatedEvent of(PicturePayload root) {
        return new ProfilePictureCreatedEvent(root);
    }
}

