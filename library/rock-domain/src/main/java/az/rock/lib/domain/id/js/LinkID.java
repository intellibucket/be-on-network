package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class LinkID extends RootID<UUID> implements IdReference<UUID> {

    public static final LinkID NULL = new LinkID(null);
    protected LinkID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static LinkID of(UUID value){
        return new LinkID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof LinkID)) return false;
        return this.getAbsoluteID().equals(((LinkID)o).getAbsoluteID());
    }
}
