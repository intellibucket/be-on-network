package az.rock.lib.event.impl.concretes.auth;

import az.rock.lib.event.Event;
import az.rock.lib.event.impl.abstracts.AbstractStartDomainEvent;
import az.rock.lib.event.impl.concretes.payload.PicturePayload;

@Event
public class CoverPictureCreatedEvent extends AbstractStartDomainEvent<PicturePayload> {
    protected CoverPictureCreatedEvent(PicturePayload root) {
        super(root);
    }

    public static CoverPictureCreatedEvent of(PicturePayload root) {
        return new CoverPictureCreatedEvent(root);
    }
}

