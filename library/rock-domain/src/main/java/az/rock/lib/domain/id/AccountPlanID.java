package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class AccountPlanID extends RootID<UUID> implements IdReference<UUID> {
    protected AccountPlanID(UUID value) {
        super(value);
    }

    @Override
    public UUID getId() {
        return super.getUUID();
    }

    public static AccountPlanID of(UUID value) {
        return new AccountPlanID(value);
    }
}
