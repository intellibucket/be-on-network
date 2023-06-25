package az.rock.flyjob.auth.event.email;

import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.Event;

@Event
public class EmailUpdatedEvent extends AbstractDomainEvent<EmailRoot> {
    protected EmailUpdatedEvent(EmailRoot root) {
        super(root);
    }

    public static EmailUpdatedEvent of(EmailRoot root) {
        return new EmailUpdatedEvent(root);
    }
}