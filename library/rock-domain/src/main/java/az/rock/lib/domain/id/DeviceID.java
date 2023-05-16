package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class DeviceID  extends RootID<UUID> implements IdReference<UUID> {
    protected DeviceID(UUID value) {
        super(value);
    }

    @Override
    public UUID getId() {
        return super.getUUID();
    }

    public static DeviceID of(UUID value) {
        return new DeviceID(value);
    }
}
