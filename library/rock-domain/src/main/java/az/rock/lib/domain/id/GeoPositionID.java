package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class GeoPositionID  extends RootID<UUID> implements IdReference<UUID> {
    protected GeoPositionID(UUID value) {
        super(value);
    }

    @Override
    public UUID getId() {
        return super.getUUID();
    }

    public static GeoPositionID of(UUID value) {
        return new GeoPositionID(value);
    }
}
