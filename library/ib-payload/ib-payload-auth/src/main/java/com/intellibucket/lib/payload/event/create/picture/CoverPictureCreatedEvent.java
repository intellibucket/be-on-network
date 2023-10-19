package com.intellibucket.lib.payload.event.create.picture;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.picture.PicturePayload;

@Event
public class CoverPictureCreatedEvent extends AbstractStartDomainEvent<PicturePayload> {
    protected CoverPictureCreatedEvent(PicturePayload root) {
        super(root);
    }

    public static CoverPictureCreatedEvent of(PicturePayload root) {
        return new CoverPictureCreatedEvent(root);
    }
}

