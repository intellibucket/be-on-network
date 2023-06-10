package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class UserID extends RootID<UUID> implements IdReference<UUID> {

    public static final UserID NULL = new UserID(null);
    protected UserID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static UserID of(UUID value){
        return new UserID(value);
    }
}
