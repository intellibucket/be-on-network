package az.rock.lib.domain.id.auth;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class AuthorityID extends RootID<UUID> implements IdReference<UUID> {
    protected AuthorityID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static AuthorityID of(UUID value) {
        return new AuthorityID(value);
    }
}
