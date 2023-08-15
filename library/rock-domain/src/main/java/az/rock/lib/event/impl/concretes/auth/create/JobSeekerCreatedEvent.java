package az.rock.lib.event.impl.concretes.auth.create;

import az.rock.lib.event.Event;
import az.rock.lib.event.impl.abstracts.AbstractStartDomainEvent;
import az.rock.lib.event.payload.registration.UserRegistrationPayload;

@Event
public class JobSeekerCreatedEvent extends AbstractStartDomainEvent<UserRegistrationPayload> {
    protected JobSeekerCreatedEvent(UserRegistrationPayload payload) {
        super(payload);
    }

    public static JobSeekerCreatedEvent of(UserRegistrationPayload payload) {
        return new JobSeekerCreatedEvent(payload);
    }
}
