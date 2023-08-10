package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class OrganizationID extends RootID<UUID> implements IdReference<UUID> {

    public static final OrganizationID NULL = new OrganizationID(null);
    protected OrganizationID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static OrganizationID of(UUID value){
        return new OrganizationID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof OrganizationID)) return false;
        return this.getAbsoluteID().equals(((OrganizationID)o).getAbsoluteID());
    }
}
