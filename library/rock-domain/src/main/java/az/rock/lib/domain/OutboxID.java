package az.rock.lib.domain;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.domain.id.AccountPlanID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

@ValueObject
public class OutboxID  extends RootID<UUID> implements IdReference<UUID> {
    public static final OutboxID NULL = new OutboxID(null);

    protected OutboxID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static OutboxID of(UUID value) {
        return new OutboxID(value);
    }
}