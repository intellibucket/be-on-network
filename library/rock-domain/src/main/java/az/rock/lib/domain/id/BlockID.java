package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class BlockID extends RootID<UUID> implements IdReference<UUID> {

    public static final BlockID NULL = new BlockID(null);
    protected BlockID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static BlockID of(UUID value){
        return new BlockID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof BlockID)) return false;
        return this.getAbsoluteID().equals(((BlockID)o).getAbsoluteID());
    }
}
