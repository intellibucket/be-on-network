package com.intellibucket.lib.payload.event.create.user;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;

;

@Event
public class JobSeekerCreatedEvent extends AbstractStartDomainEvent<JobSeekerRegistrationPayload> {
    protected JobSeekerCreatedEvent(JobSeekerRegistrationPayload payload) {
        super(payload);
    }

    public JobSeekerCreatedEvent() {
        super();
    }

    public static JobSeekerCreatedEvent of(JobSeekerRegistrationPayload payload) {
        return new JobSeekerCreatedEvent(payload);
    }
}
