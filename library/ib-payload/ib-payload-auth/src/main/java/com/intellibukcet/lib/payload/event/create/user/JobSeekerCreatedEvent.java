package com.intellibukcet.lib.payload.event.create.user;

;
import com.intellibukcet.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;
import com.intellibukcet.lib.payload.payload.reg.JobSeekerRegistrationPayload;

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
