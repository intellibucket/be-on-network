package com.intellibukcet.lib.payload.event.create.picture;

import com.intellibukcet.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;
import com.intellibukcet.lib.payload.payload.picture.PicturePayload;

@Event
public class CoverPictureCreatedEvent extends AbstractStartDomainEvent<PicturePayload> {
    protected CoverPictureCreatedEvent(PicturePayload root) {
        super(root);
    }

    public static CoverPictureCreatedEvent of(PicturePayload root) {
        return new CoverPictureCreatedEvent(root);
    }
}

