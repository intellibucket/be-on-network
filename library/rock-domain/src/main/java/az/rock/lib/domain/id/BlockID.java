package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class BlockID extends RootID<UUID> implements IdReference<UUID> {
    protected BlockID(UUID value) {
        super(value);
    }

    public static BlockID of(UUID value) {
        return new BlockID(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
