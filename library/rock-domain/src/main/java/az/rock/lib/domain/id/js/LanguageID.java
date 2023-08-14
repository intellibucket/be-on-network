package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class LanguageID extends RootID<UUID> implements IdReference<UUID> {

    public static final LanguageID NULL = new LanguageID(null);
    protected LanguageID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static LanguageID of(UUID value){
        return new LanguageID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof LanguageID)) return false;
        return this.getAbsoluteID().equals(((LanguageID)o).getAbsoluteID());
    }
}
