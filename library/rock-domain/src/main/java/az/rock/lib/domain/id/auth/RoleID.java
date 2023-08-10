package az.rock.lib.domain.id.auth;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class RoleID extends RootID<UUID> implements IdReference<UUID> {
    protected RoleID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static RoleID of(UUID value){
        return new RoleID(value);
    }
}
