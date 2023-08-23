package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.trx.Saga;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@InputPort
public interface AbstractResumeCommandDomainPresentationService {
    void create(Saga<JobSeekerCreatedEvent> jobSeekerCreatedEventSaga);
}
