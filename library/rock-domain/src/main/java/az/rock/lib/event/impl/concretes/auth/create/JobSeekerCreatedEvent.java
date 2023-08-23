package az.rock.lib.event.impl.concretes.auth.create;

import az.rock.lib.event.Event;
import az.rock.lib.event.impl.abstracts.AbstractStartDomainEvent;
import az.rock.lib.event.payload.registration.JobSeekerRegistrationPayload;

@Event
public class JobSeekerCreatedEvent extends AbstractStartDomainEvent<JobSeekerRegistrationPayload> {
    protected JobSeekerCreatedEvent(JobSeekerRegistrationPayload payload) {
        super(payload);
    }

    public JobSeekerCreatedEvent(){
        super();
    }

    public static JobSeekerCreatedEvent of(JobSeekerRegistrationPayload payload) {
        return new JobSeekerCreatedEvent(payload);
    }
}
