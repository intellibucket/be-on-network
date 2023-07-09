package az.rock.flyjob.auth.event.user;

import az.rock.flyjob.auth.root.user.CoverPictureRoot;
import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.Event;

@Event
public class CoverPictureCreatedEvent extends AbstractDomainEvent<CoverPictureRoot> {
    protected CoverPictureCreatedEvent(CoverPictureRoot root) {
        super(root);
    }

    public static CoverPictureCreatedEvent of(CoverPictureRoot root) {
        return new CoverPictureCreatedEvent(root);
    }
}

