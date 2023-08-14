package az.rock.lib.event.impl.concretes.auth;

import az.rock.lib.event.Event;
import az.rock.lib.event.impl.abstracts.AbstractStartDomainEvent;
import az.rock.lib.event.impl.concretes.payload.PicturePayload;

@Event
public class ProfilePictureCreatedEvent extends AbstractStartDomainEvent<PicturePayload> {
    protected ProfilePictureCreatedEvent(PicturePayload root) {
        super(root);
    }

    public static ProfilePictureCreatedEvent of(PicturePayload root) {
        return new ProfilePictureCreatedEvent(root);
    }
}

