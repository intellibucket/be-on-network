package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class ProjectID extends RootID<UUID> implements IdReference<UUID> {

    public static final ProjectID NULL = new ProjectID(null);
    protected ProjectID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static ProjectID of(UUID value){
        return new ProjectID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof ProjectID)) return false;
        return this.getAbsoluteID().equals(((ProjectID)o).getAbsoluteID());
    }
}
