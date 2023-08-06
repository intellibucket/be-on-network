package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class JobTitleInformationID extends RootID<UUID> implements IdReference<UUID> {

    public static final JobTitleInformationID NULL = new JobTitleInformationID(null);
    protected JobTitleInformationID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static JobTitleInformationID of(UUID value){
        return new JobTitleInformationID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof JobTitleInformationID)) return false;
        return this.getAbsoluteID().equals(((JobTitleInformationID)o).getAbsoluteID());
    }
}
