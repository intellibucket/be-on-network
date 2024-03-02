package az.rock.lib.domain.id.payment;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class PaymentHistoryID extends RootID<UUID> implements IdReference<UUID> {

    public PaymentHistoryID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
