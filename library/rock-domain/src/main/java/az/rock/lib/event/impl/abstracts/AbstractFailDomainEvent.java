package az.rock.lib.event.impl.abstracts;

import az.rock.lib.event.AbstractDomainEvent;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AbstractFailDomainEvent <R> extends AbstractDomainEvent<R> {
    protected AbstractFailDomainEvent(UUID trackingId, ZonedDateTime time, R root) {
        super(trackingId, time, root);
    }

    protected AbstractFailDomainEvent(R root) {
        super(root);
    }

    @Override
    public String getEventType() {
        return EventType.FAIL.name();
    }
}