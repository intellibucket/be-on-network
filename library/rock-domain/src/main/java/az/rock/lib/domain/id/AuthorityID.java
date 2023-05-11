package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class AuthorityID extends RootID<UUID> implements IdReference<UUID> {
    protected AuthorityID(UUID value) {
        super(value);
    }

    @Override
    public UUID getId() {
        return super.getUUID();
    }

    public static AuthorityID of(UUID value) {
        return new AuthorityID(value);
    }
}
