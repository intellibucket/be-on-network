package az.rock.auth.domain.presentation.coordinator.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractJobSeekerCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import az.rock.flyjob.auth.event.user.JobSeekerCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class JobSeekerCreateEventCoordinator extends AbstractJobSeekerCreateEventCoordinator {
    private AbstractUserMessagePublisher userMessagePublisher;


    @Override
    protected void proceed(JobSeekerCreatedEvent event) {

    }

    @Override
    public void error() {

    }

    @Override
    public void onFail() {

    }

    @Override
    public void onSuccess() {

    }
}
