package az.rock.flyjob.auth.event;

import az.rock.flyjob.auth.model.root.user.PasswordRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;

public class PasswordUpdatedEvent extends AbstractDomainEvent<PasswordRoot> {
    protected PasswordUpdatedEvent(PasswordRoot root) {
        super(root);
    }

    public static PasswordUpdatedEvent of(PasswordRoot root) {
        return new PasswordUpdatedEvent(root);
    }
}
