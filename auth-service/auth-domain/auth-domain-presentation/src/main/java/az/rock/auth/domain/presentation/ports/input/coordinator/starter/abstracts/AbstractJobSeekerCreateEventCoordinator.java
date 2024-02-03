package az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import az.rock.lib.coordinator.outbox.AbstractOutboxInputPort;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.outbox.JobSeekerRegistrationSteps;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractJobSeekerCreateEventCoordinator extends AbstractUserCreateEventCoordinator<JobSeekerCreatedEvent> {
    public AbstractJobSeekerCreateEventCoordinator(AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher,
                                                   AbstractOutboxInputPort outboxProcess) {
        super(userMessagePublisher, outboxProcess);
    }

    @Override
    public List<String> allSteps() {
        return Arrays.stream(JobSeekerRegistrationSteps.values()).map(Enum::name).toList();
    }
}
