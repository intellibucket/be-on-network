package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class ReferenceID extends RootID<UUID> implements IdReference<UUID> {

    public static final ReferenceID NULL = new ReferenceID(null);
    protected ReferenceID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static ReferenceID of(UUID value){
        return new ReferenceID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof ReferenceID)) return false;
        return this.getAbsoluteID().equals(((ReferenceID)o).getAbsoluteID());
    }
}
