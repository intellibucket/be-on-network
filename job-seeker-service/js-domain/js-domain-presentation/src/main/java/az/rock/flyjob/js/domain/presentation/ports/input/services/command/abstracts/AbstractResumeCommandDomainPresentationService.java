package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.lib.annotation.InputPort;
import com.intellibukcet.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibukcet.lib.payload.trx.Saga;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@InputPort
public interface AbstractResumeCommandDomainPresentationService {
    void create(Saga<JobSeekerCreatedEvent> jobSeekerCreatedEventSaga);
}
