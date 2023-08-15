package az.rock.lib.event;

import az.rock.lib.event.impl.abstracts.JsonTypeReference;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class AbstractDomainEvent<D> implements DomainEvent<D> , JsonTypeReference {
    private final UUID trackingId;
    private final ZonedDateTime time;
    private final D data;

    protected AbstractDomainEvent(UUID trackingId, ZonedDateTime time, D data) {
        this.trackingId = trackingId;
        this.time = time;
        this.data = data;
    }

    protected AbstractDomainEvent(D data) {
        this.trackingId = UUID.randomUUID();
        this.time = ZonedDateTime.now(ZoneId.of("UTC"));
        this.data = data;
    }

    public UUID getTrackingId() {
        return trackingId;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public D getData() {
        return data;
    }

}
