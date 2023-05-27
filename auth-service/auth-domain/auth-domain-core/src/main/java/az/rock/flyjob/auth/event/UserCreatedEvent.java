package az.rock.flyjob.auth.event;

import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.event.AbstractDomainEvent;

public class UserCreatedEvent extends AbstractDomainEvent<UserRoot> {
    protected UserCreatedEvent(UserRoot root) {
        super(root);
    }

    public static UserCreatedEvent of(UserRoot root) {
        return new UserCreatedEvent(root);
    }
}
