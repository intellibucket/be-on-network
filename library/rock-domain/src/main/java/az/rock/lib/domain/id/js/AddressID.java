package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class AddressID extends RootID<UUID> implements IdReference<UUID> {

    public static final AddressID NULL = new AddressID(null);
    protected AddressID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static AddressID of(UUID value){
        return new AddressID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof AddressID)) return false;
        return this.getAbsoluteID().equals(((AddressID)o).getAbsoluteID());
    }
}
