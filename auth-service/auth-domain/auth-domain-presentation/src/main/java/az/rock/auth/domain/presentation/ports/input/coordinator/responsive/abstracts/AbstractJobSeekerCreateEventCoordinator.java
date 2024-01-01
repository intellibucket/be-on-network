package az.rock.auth.domain.presentation.ports.input.coordinator.responsive.abstracts;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;

public abstract class AbstractJobSeekerCreateEventCoordinator extends AbstractUserCreateEventCoordinator<JobSeekerCreatedEvent> {
    public AbstractJobSeekerCreateEventCoordinator(AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher) {
        super(userMessagePublisher);
    }
}
