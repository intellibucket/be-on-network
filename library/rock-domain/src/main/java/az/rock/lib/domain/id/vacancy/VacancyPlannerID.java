package az.rock.lib.domain.id.vacancy;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class VacancyPlannerID extends RootID<UUID>  implements IdReference<UUID> {
    protected VacancyPlannerID(UUID value) {
        super(value);
    }
    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
