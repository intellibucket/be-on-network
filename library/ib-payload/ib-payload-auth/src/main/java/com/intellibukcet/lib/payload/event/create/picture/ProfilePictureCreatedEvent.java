package com.intellibukcet.lib.payload.event.create.picture;


import com.intellibukcet.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;
import com.intellibukcet.lib.payload.payload.picture.PicturePayload;

@Event
public class ProfilePictureCreatedEvent extends AbstractStartDomainEvent<PicturePayload> {
    protected ProfilePictureCreatedEvent(PicturePayload root) {
        super(root);
    }

    public static ProfilePictureCreatedEvent of(PicturePayload root) {
        return new ProfilePictureCreatedEvent(root);
    }
}

