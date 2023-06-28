package az.rock.flyjob.auth.event.user;

import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.event.AbstractDomainEvent;

public class UserSettingsUpdatedEvent extends AbstractDomainEvent<UserSettingsRoot> {
    protected UserSettingsUpdatedEvent(UserSettingsRoot root) {
        super(root);
    }

    public static UserSettingsUpdatedEvent of(UserSettingsRoot root) {
        return new UserSettingsUpdatedEvent(root);
    }
}
