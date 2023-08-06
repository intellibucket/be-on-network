package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class SkillID extends RootID<UUID> implements IdReference<UUID> {

    public static final SkillID NULL = new SkillID(null);
    protected SkillID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static SkillID of(UUID value){
        return new SkillID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof SkillID)) return false;
        return this.getAbsoluteID().equals(((SkillID)o).getAbsoluteID());
    }
}
