package az.rock.flyjob.auth.event.email;

import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.Event;

@Event
public class EmailCreatedEvent extends AbstractDomainEvent<EmailRoot> {
    protected EmailCreatedEvent(EmailRoot root) {
        super(root);
    }

    public static EmailCreatedEvent of(EmailRoot root) {
        return new EmailCreatedEvent(root);
    }
}