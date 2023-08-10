package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class PublicationID extends RootID<UUID> implements IdReference<UUID> {

    public static final PublicationID NULL = new PublicationID(null);
    protected PublicationID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static PublicationID of(UUID value){
        return new PublicationID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof PublicationID)) return false;
        return this.getAbsoluteID().equals(((PublicationID)o).getAbsoluteID());
    }
}
