package az.rock.lib.domain.id.company;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class CompanyProfileID extends RootID<UUID> implements IdReference<UUID> {

    protected CompanyProfileID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

}

