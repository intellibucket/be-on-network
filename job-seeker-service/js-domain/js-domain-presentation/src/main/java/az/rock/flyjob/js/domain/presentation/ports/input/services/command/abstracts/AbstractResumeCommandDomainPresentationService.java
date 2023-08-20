package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.trx.Saga;

public interface AbstractResumeCommandDomainPresentationService {
    void create(Saga<JobSeekerCreatedEvent> jobSeekerCreatedEventSaga);
}
