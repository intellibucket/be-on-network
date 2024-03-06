package az.rock.lib.domain.id.payment;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class PayerID extends RootID<UUID> implements IdReference<UUID> {

    public PayerID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
