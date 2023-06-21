package az.rock.flyjob.auth.event;

import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.Event;

@Event
public class UserUpdatedEvent extends AbstractDomainEvent<UserRoot> {
    protected UserUpdatedEvent(UserRoot root) {
        super(root);
    }

    public static UserUpdatedEvent of(UserRoot root) {
        return new UserUpdatedEvent(root);
    }
}

