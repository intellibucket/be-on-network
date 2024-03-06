package az.rock.lib.domain.id.vacancy;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class VacancyPriorityID extends RootID<UUID>  implements IdReference<UUID> {
    protected VacancyPriorityID(UUID value) {
        super(value);
    }
    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
