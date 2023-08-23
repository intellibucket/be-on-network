package com.intellibukcet.lib.payload.event.create.picture;

import az.rock.lib.event.Event;
import az.rock.lib.event.impl.abstracts.AbstractStartDomainEvent;
import az.rock.lib.event.payload.PicturePayload;

@Event
public class ProfilePictureCreatedEvent extends AbstractStartDomainEvent<PicturePayload> {
    protected ProfilePictureCreatedEvent(PicturePayload root) {
        super(root);
    }

    public static ProfilePictureCreatedEvent of(PicturePayload root) {
        return new ProfilePictureCreatedEvent(root);
    }
}

