package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractResumeCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractResumeCommandDomainPresentationService;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.outbox.JobSeekerRegistrationSteps;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import org.springframework.stereotype.Component;

@Component
public class ResumeCommandDomainPresentationService implements AbstractResumeCommandDomainPresentationService {

    private final AbstractResumeCreateCommandHandler resumeCreateCommandHandler;

    public ResumeCommandDomainPresentationService(AbstractResumeCreateCommandHandler resumeCreateCommandHandler) {
        this.resumeCreateCommandHandler = resumeCreateCommandHandler;
    }

    @Override
    public void create(AbstractSagaProcess<JobSeekerCreatedEvent> jobSeekerCreatedEventSagaProcess) {
        var event = jobSeekerCreatedEventSagaProcess.getEvent();
        var resultEvent = this.resumeCreateCommandHandler.createResume(event);
        var sagaProcess = AbstractSagaProcess.of(jobSeekerCreatedEventSagaProcess, JobSeekerRegistrationSteps.CREATING_JOB_SEEKER_PROFILE, resultEvent);
    }
}
