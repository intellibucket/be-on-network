package az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import az.rock.lib.coordinator.ProcessProperty;
import az.rock.lib.coordinator.outbox.AbstractOutboxInputPort;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.outbox.CompanyRegistrationSteps;
import com.intellibucket.lib.payload.outbox.JobSeekerRegistrationSteps;

import java.util.Arrays;

public abstract class AbstractJobSeekerCreateEventCoordinator extends AbstractUserCreateEventCoordinator<JobSeekerCreatedEvent> {
    public AbstractJobSeekerCreateEventCoordinator(AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher,
                                                   AbstractOutboxInputPort outboxProcess) {
        super(userMessagePublisher, outboxProcess);
    }

    @Override
    public ProcessProperty getProcess() {
        return new ProcessProperty(JobSeekerRegistrationSteps.ON_STARTED_STEP.getProcessName(), JobSeekerRegistrationSteps.ON_STARTED_STEP.name(), Arrays.stream(CompanyRegistrationSteps.values()).map(Enum::name).toList());
    }
}
