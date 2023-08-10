package az.rock.lib.domain.id.auth;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class UserSettingsID  extends RootID<UUID> implements IdReference<UUID> {
    protected UserSettingsID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static UserSettingsID of(UUID value) {
        return new UserSettingsID(value);
    }
}
