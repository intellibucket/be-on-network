package az.rock.lib.domain.id.vacancy;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class VacancyID extends RootID<UUID>  implements IdReference<UUID> {
    public VacancyID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
