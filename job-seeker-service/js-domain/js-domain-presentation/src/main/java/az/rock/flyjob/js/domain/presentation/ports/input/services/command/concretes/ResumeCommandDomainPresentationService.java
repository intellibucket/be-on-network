package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractResumeCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractResumeCommandDomainPresentationService;
import com.intellibukcet.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibukcet.lib.payload.trx.Saga;
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
