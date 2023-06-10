package az.rock.lib.event;

import az.rock.lib.domain.RootID;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class AbstractDomainEvent<R> implements DomainEvent<R> {
    private final UUID trackingId;
    private final ZonedDateTime time;
    private final R root;

    protected AbstractDomainEvent(UUID trackingId, ZonedDateTime time, R root) {
        this.trackingId = trackingId;
        this.time = time;
        this.root = root;
    }

    protected AbstractDomainEvent(R root) {
        this.trackingId = UUID.randomUUID();
        this.time = ZonedDateTime.now(ZoneId.of("UTC"));
        this.root = root;
    }

    public UUID getTrackingId() {
        return trackingId;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public R getRoot() {
        return root;
    }

}
