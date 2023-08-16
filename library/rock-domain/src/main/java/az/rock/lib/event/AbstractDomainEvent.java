package az.rock.lib.event;

import az.rock.lib.event.impl.abstracts.JsonTypeReference;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class AbstractDomainEvent<D> implements DomainEvent<D> , JsonTypeReference {
    private final D data;

    protected AbstractDomainEvent(D data) {
        this.data = data;
    }

    public D getData() {
        return data;
    }
}
