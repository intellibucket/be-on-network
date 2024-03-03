package az.rock.lib.domain.id.payment;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class FeatureBillingID extends RootID<UUID> implements IdReference<UUID> {

    public FeatureBillingID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
