package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class LayoutID extends RootID<UUID> implements IdReference<UUID> {

    public static final LayoutID NULL = new LayoutID(null);
    protected LayoutID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static LayoutID of(UUID value){
        return new LayoutID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof LayoutID)) return false;
        return this.getAbsoluteID().equals(((LayoutID)o).getAbsoluteID());
    }
}
