package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class UserID extends RootID<UUID> implements IdReference<UUID> {
    protected UserID(UUID value) {
        super(value);
    }

    @Override
    public UUID getId() {
        return super.getUUID();
    }

    public static UserID of(UUID value){
        return new UserID(value);
    }
}