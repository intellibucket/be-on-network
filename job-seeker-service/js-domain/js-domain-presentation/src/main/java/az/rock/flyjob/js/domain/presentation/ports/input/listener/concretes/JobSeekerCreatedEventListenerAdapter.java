package az.rock.flyjob.js.domain.presentation.ports.input.listener.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.listener.abstracts.AbstractJobSeekerCreatedEventListenerAdapter;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractResumeCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.trx.Saga;
import org.springframework.stereotype.Component;

@InputPort
@Component
public class JobSeekerCreatedEventListenerAdapter implements AbstractJobSeekerCreatedEventListenerAdapter {
    private final AbstractResumeCommandDomainPresentationService resumeCommandDomainPresentationService;

    public JobSeekerCreatedEventListenerAdapter(AbstractResumeCommandDomainPresentationService resumeCommandDomainPresentationService) {
        this.resumeCommandDomainPresentationService = resumeCommandDomainPresentationService;
    }

    @Override
    public void consume(Saga<JobSeekerCreatedEvent> eventSaga) {
        this.resumeCommandDomainPresentationService.create(eventSaga);
    }
}
