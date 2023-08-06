package az.rock.lib.domain.id.auth;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class DetailID extends RootID<UUID> implements IdReference<UUID> {
    protected DetailID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static DetailID of(UUID value){
        return new DetailID(value);
    }
}
