package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class CustomPaneID extends RootID<UUID> implements IdReference<UUID> {

    public static final CustomPaneID NULL = new CustomPaneID(null);
    protected CustomPaneID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static CustomPaneID of(UUID value){
        return new CustomPaneID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof CustomPaneID)) return false;
        return this.getAbsoluteID().equals(((CustomPaneID)o).getAbsoluteID());
    }
}
