package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.impl.concretes.js.create.ResumeCreatedEvent;
import az.rock.lib.event.payload.Payload;
import az.rock.lib.event.trx.Saga;

public interface AbstractResumeCreateCommandHandler {
    AbstractDomainEvent<?> createResume(JobSeekerCreatedEvent event);
}
