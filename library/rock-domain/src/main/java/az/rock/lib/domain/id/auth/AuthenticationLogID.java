package az.rock.lib.domain.id.auth;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class AuthenticationLogID extends RootID<UUID> implements IdReference<UUID> {
    protected AuthenticationLogID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static AuthenticationLogID of(UUID value) {
        return new AuthenticationLogID(value);
    }
}

