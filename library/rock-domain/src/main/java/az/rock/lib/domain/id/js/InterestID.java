package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class InterestID extends RootID<UUID> implements IdReference<UUID> {

    public static final InterestID NULL = new InterestID(null);
    protected InterestID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static InterestID of(UUID value){
        return new InterestID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof InterestID)) return false;
        return this.getAbsoluteID().equals(((InterestID)o).getAbsoluteID());
    }
}
