package az.rock.flyjob.js.domain.presentation.ports.input.listener.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.listener.abstracts.AbstractJobSeekerCreatedEventListenerAdapter;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractResumeCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import org.springframework.stereotype.Component;

@InputPort
@Component
public class JobSeekerCreatedEventListenerAdapter implements AbstractJobSeekerCreatedEventListenerAdapter {
    private final AbstractResumeCommandDomainPresentationService resumeCommandDomainPresentationService;

    public JobSeekerCreatedEventListenerAdapter(AbstractResumeCommandDomainPresentationService resumeCommandDomainPresentationService) {
        this.resumeCommandDomainPresentationService = resumeCommandDomainPresentationService;
    }

    @Override
    public void consume(AbstractSagaProcess<JobSeekerCreatedEvent> eventSagaProcess) {
        this.resumeCommandDomainPresentationService.create(eventSagaProcess);
    }
}
