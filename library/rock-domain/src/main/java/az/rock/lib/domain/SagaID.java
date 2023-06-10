package az.rock.lib.domain;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

@ValueObject
public class SagaID extends RootID<UUID> implements IdReference<UUID> {
    public static final SagaID NULL = new SagaID(null);

    protected SagaID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static SagaID of(UUID value) {
        return new SagaID(value);
    }
}