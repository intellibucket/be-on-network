package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class ResumeTemplateID extends RootID<UUID> implements IdReference<UUID> {

    public static final ResumeTemplateID NULL = new ResumeTemplateID(null);
    protected ResumeTemplateID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static ResumeTemplateID of(UUID value){
        return new ResumeTemplateID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof ResumeTemplateID)) return false;
        return this.getAbsoluteID().equals(((ResumeTemplateID)o).getAbsoluteID());
    }
}
