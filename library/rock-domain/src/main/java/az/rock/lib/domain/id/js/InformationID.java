package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class InformationID extends RootID<UUID> implements IdReference<UUID> {

    public static final InformationID NULL = new InformationID(null);
    protected InformationID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static InformationID of(UUID value){
        return new InformationID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof InformationID)) return false;
        return this.getAbsoluteID().equals(((InformationID)o).getAbsoluteID());
    }
}
