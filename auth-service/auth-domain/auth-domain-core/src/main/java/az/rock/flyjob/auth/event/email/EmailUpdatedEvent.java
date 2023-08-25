package az.rock.flyjob.auth.event.email;

import az.rock.flyjob.auth.root.user.EmailRoot;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;

@Event
public class EmailUpdatedEvent extends AbstractDomainEvent<EmailRoot> {
    protected EmailUpdatedEvent(EmailRoot root) {
        super(root);
    }

    public static EmailUpdatedEvent of(EmailRoot root) {
        return new EmailUpdatedEvent(root);
    }
}