package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class ResumeID extends RootID<UUID> implements IdReference<UUID> {

    public static final ResumeID NULL = new ResumeID(null);
    protected ResumeID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static ResumeID of(UUID value){
        return new ResumeID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof ResumeID)) return false;
        return this.getAbsoluteID().equals(((ResumeID)o).getAbsoluteID());
    }
}
