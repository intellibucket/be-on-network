package az.rock.flyjob.auth.event;

import az.rock.flyjob.auth.root.UserRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.DomainEvent;

import java.time.ZonedDateTime;
import java.util.UUID;

public class UserCreatedEvent extends AbstractDomainEvent<UserRoot> {
    protected UserCreatedEvent(UserRoot root) {
        super(root);
    }
}
