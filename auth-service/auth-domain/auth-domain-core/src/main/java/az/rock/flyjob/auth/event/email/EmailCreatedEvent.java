package az.rock.flyjob.auth.event.email;

import az.rock.flyjob.auth.model.root.user.EmailRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;

@Event
public class EmailCreatedEvent extends AbstractDomainEvent<EmailRoot> {
    protected EmailCreatedEvent(EmailRoot root) {
        super(root);
    }

    public static EmailCreatedEvent of(EmailRoot root) {
        return new EmailCreatedEvent(root);
    }
}