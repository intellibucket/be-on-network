package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class DetailID extends RootID<UUID> implements IdReference<UUID> {
    protected DetailID(UUID value) {
        super(value);
    }

    @Override
    public UUID getId() {
        return super.getUUID();
    }

    public static DetailID of(UUID value){
        return new DetailID(value);
    }
}
