package az.rock.flyjob.auth.event;

import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.Event;

@Event
public class CompanyCreatedEvent extends AbstractDomainEvent<UserRoot> {
    protected CompanyCreatedEvent(UserRoot root) {
        super(root);
    }

    public static CompanyCreatedEvent of(UserRoot root) {
        return new CompanyCreatedEvent(root);
    }
}
