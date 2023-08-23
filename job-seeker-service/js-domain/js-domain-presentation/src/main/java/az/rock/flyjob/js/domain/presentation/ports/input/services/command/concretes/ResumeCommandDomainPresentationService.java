package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractResumeCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractResumeCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.trx.Saga;
import org.springframework.stereotype.Component;

@Component
public class ResumeCommandDomainPresentationService implements AbstractResumeCommandDomainPresentationService {

    private final AbstractResumeCreateCommandHandler resumeCreateCommandHandler;

    public ResumeCommandDomainPresentationService(AbstractResumeCreateCommandHandler resumeCreateCommandHandler) {
        this.resumeCreateCommandHandler = resumeCreateCommandHandler;
    }

    @Override
    public void create(Saga<JobSeekerCreatedEvent> jobSeekerCreatedEventSaga) {
        var event = jobSeekerCreatedEventSaga.getEvent();
        var resultEvent = this.resumeCreateCommandHandler.createResume(event);
        var saga = Saga.of(jobSeekerCreatedEventSaga,resultEvent);
    }
}
