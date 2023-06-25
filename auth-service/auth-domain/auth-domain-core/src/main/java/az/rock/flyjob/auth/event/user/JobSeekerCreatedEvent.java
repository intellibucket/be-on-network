package az.rock.flyjob.auth.event.user;

import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.Event;

@Event
public class JobSeekerCreatedEvent extends AbstractDomainEvent<UserRoot> {
    protected JobSeekerCreatedEvent(UserRoot root) {
        super(root);
    }

    public static JobSeekerCreatedEvent of(UserRoot root) {
        return new JobSeekerCreatedEvent(root);
    }
}
