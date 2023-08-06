package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class AwardID extends RootID<UUID> implements IdReference<UUID> {

    public static final AwardID NULL = new AwardID(null);
    protected AwardID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static AwardID of(UUID value){
        return new AwardID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof AwardID)) return false;
        return this.getAbsoluteID().equals(((AwardID)o).getAbsoluteID());
    }
}
