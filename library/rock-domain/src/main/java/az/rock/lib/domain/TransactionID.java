package az.rock.lib.domain;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

@ValueObject
public class TransactionID extends RootID<UUID> implements IdReference<UUID> {
    public static final TransactionID NULL = new TransactionID(null);

    public TransactionID() {
        super();
    }

    public TransactionID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static TransactionID of(UUID value) {
        return new TransactionID(value);
    }
}