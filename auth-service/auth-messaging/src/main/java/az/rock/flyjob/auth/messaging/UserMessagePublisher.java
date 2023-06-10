package az.rock.flyjob.auth.messaging;

import az.rock.auth.domain.presentation.ports.output.message.AbstractUserMessagePublisher;
import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.JobSeekerCreatedEvent;
import model.auth.UserCreatedEventPayload;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserMessagePublisher implements AbstractUserMessagePublisher {
    private final KafkaTemplate<String, UserCreatedEventPayload> userCreatedEventKafkaTemplate;

    public UserMessagePublisher(KafkaTemplate<String, UserCreatedEventPayload> userCreatedEventKafkaTemplate) {
        this.userCreatedEventKafkaTemplate = userCreatedEventKafkaTemplate;
    }

    @Override
    public void publish(JobSeekerCreatedEvent jobSeekerCreatedEvent) {
        var root = jobSeekerCreatedEvent.getRoot();
        var model = UserCreatedEventPayload.of(root.getRootID().getAbsoluteID(), root.getUserType());
        this.userCreatedEventKafkaTemplate.send("job-seeker-created", model);
    }

    @Override
    public void publish(CompanyCreatedEvent companyCreatedEvent) {
        var root = companyCreatedEvent.getRoot();
        var model = UserCreatedEventPayload.of(root.getRootID().getAbsoluteID(), root.getUserType());
        this.userCreatedEventKafkaTemplate.send("company-created", model);
    }
}
