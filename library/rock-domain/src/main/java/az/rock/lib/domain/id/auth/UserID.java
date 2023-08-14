package az.rock.lib.domain.id.auth;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

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

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof UserID)) return false;
        return this.getAbsoluteID().equals(((UserID)o).getAbsoluteID());
    }
}
