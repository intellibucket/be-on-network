package az.rock.lib.event.impl.concretes;

import az.rock.lib.event.impl.abstracts.AbstractFailDomainEvent;
import az.rock.lib.event.payload.FailPayload;

import java.util.List;

public class FailDomainEvent extends AbstractFailDomainEvent<FailPayload> {
    protected FailDomainEvent(FailPayload payload) {
        super(payload);
    }

    public static FailDomainEvent of(List<String> message) {
        return new FailDomainEvent(new FailPayload(message));
    }

    public static FailDomainEvent of(String message) {
        return new FailDomainEvent(new FailPayload(message));
    }
}
