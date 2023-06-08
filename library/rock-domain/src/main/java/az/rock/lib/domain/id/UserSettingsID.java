package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class UserSettingsID  extends RootID<UUID> implements IdReference<UUID> {
    protected UserSettingsID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getUUID();
    }

    public static UserSettingsID of(UUID value) {
        return new UserSettingsID(value);
    }
}
