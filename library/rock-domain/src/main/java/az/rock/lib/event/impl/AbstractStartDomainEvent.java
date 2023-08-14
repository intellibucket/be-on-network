package az.rock.lib.event.impl;

import az.rock.lib.event.AbstractDomainEvent;

import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class AbstractStartDomainEvent<R> extends AbstractDomainEvent<R> {
    protected AbstractStartDomainEvent(UUID trackingId, ZonedDateTime time, R root) {
        super(trackingId, time, root);
    }

    protected AbstractStartDomainEvent(R root) {
        super(root);
    }

    @Override
    public String getEventType() {
        return EventType.START.name();
    }
}
