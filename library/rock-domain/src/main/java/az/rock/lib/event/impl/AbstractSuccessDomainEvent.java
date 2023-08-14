package az.rock.lib.event.impl;

import az.rock.lib.event.AbstractDomainEvent;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AbstractSuccessDomainEvent <R> extends AbstractDomainEvent<R> {
    protected AbstractSuccessDomainEvent(UUID trackingId, ZonedDateTime time, R root) {
        super(trackingId, time, root);
    }

    protected AbstractSuccessDomainEvent(R root) {
        super(root);
    }

    @Override
    public String getEventType() {
        return EventType.SUCCESS.name();
    }
}