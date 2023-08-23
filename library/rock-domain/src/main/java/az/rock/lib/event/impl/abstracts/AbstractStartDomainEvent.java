package az.rock.lib.event.impl.abstracts;

import az.rock.lib.event.AbstractDomainEvent;

import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class AbstractStartDomainEvent<R> extends AbstractDomainEvent<R> {
    protected AbstractStartDomainEvent(R root) {
        super(root);
    }

    public AbstractStartDomainEvent(){}

    @Override
    public String getEventType() {
        return EventType.START.name();
    }
}
