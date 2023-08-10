package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class EducationID extends RootID<UUID> implements IdReference<UUID> {

    public static final EducationID NULL = new EducationID(null);
    protected EducationID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static EducationID of(UUID value){
        return new EducationID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof EducationID)) return false;
        return this.getAbsoluteID().equals(((EducationID)o).getAbsoluteID());
    }
}
