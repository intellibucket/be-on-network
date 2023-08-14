package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class ResumeSettingsID extends RootID<UUID> implements IdReference<UUID> {

    public static final ResumeSettingsID NULL = new ResumeSettingsID(null);
    protected ResumeSettingsID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static ResumeSettingsID of(UUID value){
        return new ResumeSettingsID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof ResumeSettingsID)) return false;
        return this.getAbsoluteID().equals(((ResumeSettingsID)o).getAbsoluteID());
    }
}
