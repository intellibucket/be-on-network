package az.rock.flyjob.auth.event.user;

import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.Event;

@Event
public class ProfilePictureCreatedEvent extends AbstractDomainEvent<ProfilePictureRoot> {
    protected ProfilePictureCreatedEvent(ProfilePictureRoot root) {
        super(root);
    }

    public static ProfilePictureCreatedEvent of(ProfilePictureRoot root) {
        return new ProfilePictureCreatedEvent(root);
    }
}

