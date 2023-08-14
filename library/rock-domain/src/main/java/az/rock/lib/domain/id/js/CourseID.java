package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class CourseID extends RootID<UUID> implements IdReference<UUID> {

    public static final CourseID NULL = new CourseID(null);
    protected CourseID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static CourseID of(UUID value){
        return new CourseID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof CourseID)) return false;
        return this.getAbsoluteID().equals(((CourseID)o).getAbsoluteID());
    }
}
