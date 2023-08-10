package az.rock.lib.domain.id.auth;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class GeoPositionID  extends RootID<UUID> implements IdReference<UUID> {
    protected GeoPositionID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static GeoPositionID of(UUID value) {
        return new GeoPositionID(value);
    }
}
