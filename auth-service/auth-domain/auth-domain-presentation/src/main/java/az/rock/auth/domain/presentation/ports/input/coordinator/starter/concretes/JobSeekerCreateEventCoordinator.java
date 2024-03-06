package az.rock.auth.domain.presentation.ports.input.coordinator.starter.concretes;

import az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts.AbstractJobSeekerCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import az.rock.lib.coordinator.outbox.AbstractOutboxInputPort;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobSeekerCreateEventCoordinator extends AbstractJobSeekerCreateEventCoordinator {

    @Value(value = "${topic.js.created.start}")
    private String jobSeekerCreatedTopicName;


    public JobSeekerCreateEventCoordinator(AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher,
                                           AbstractOutboxInputPort outboxProcess) {
        super(userMessagePublisher, outboxProcess);
    }

    @Override
    public String getStartTopic() {
        return this.jobSeekerCreatedTopicName;
    }

    //TODO: If required it can Implement this method onSuccess and onFail

}
