package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class ResumePictureID extends RootID<UUID> implements IdReference<UUID> {

    public static final ResumePictureID NULL = new ResumePictureID(null);
    protected ResumePictureID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static ResumePictureID of(UUID value){
        return new ResumePictureID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof ResumePictureID)) return false;
        return this.getAbsoluteID().equals(((ResumePictureID)o).getAbsoluteID());
    }
}
