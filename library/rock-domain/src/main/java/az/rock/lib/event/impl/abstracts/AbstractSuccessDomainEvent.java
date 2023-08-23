package az.rock.lib.event.impl.abstracts;

import az.rock.lib.event.AbstractDomainEvent;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AbstractSuccessDomainEvent <R> extends AbstractDomainEvent<R> {

    protected AbstractSuccessDomainEvent(R payload) {
        super(payload);
    }

    @Override
    public String getEventType() {
        return EventType.SUCCESS.name();
    }
}