package az.rock.lib.domain.id.company;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;
import az.rock.lib.domain.id.auth.UserID;

import java.util.UUID;

public class CompanyID extends RootID<UUID> implements IdReference<UUID> {

    protected CompanyID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static CompanyID of(UUID value){
        return new CompanyID(value);
    }

}

