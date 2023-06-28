package az.rock.flyjob.auth.event;

import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.lib.event.AbstractDomainEvent;

public class PasswordUpdatedEvent extends AbstractDomainEvent<PasswordRoot> {
    protected PasswordUpdatedEvent(PasswordRoot root) {
        super(root);
    }

    public static PasswordUpdatedEvent of(PasswordRoot root) {
        return new PasswordUpdatedEvent(root);
    }
}
