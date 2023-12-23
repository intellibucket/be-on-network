package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.lib.annotation.InputPort;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.trx.SagaProcess;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@InputPort
public interface AbstractResumeCommandDomainPresentationService {
    void create(SagaProcess<JobSeekerCreatedEvent> jobSeekerCreatedEventSagaProcess);
}
