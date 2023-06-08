package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class AuthenticationLogID extends RootID<UUID> implements IdReference<UUID> {
    protected AuthenticationLogID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getUUID();
    }

    public static AuthenticationLogID of(UUID value) {
        return new AuthenticationLogID(value);
    }
}

