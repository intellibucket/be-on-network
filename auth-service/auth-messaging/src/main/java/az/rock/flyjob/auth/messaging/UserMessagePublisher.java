package az.rock.flyjob.auth.messaging;

import az.rock.auth.domain.presentation.ports.output.message.AbstractUserMessagePublisher;
import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.JobSeekerCreatedEvent;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.valueObject.SagaRoot;
import model.auth.UserCreatedEventPayload;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserMessagePublisher implements AbstractUserMessagePublisher {
    private final KafkaTemplate<String, SagaRoot<UserCreatedEventPayload>>userCreatedEventKafkaTemplate;

    public UserMessagePublisher(KafkaTemplate<String, SagaRoot<UserCreatedEventPayload>> userCreatedEventKafkaTemplate) {
        this.userCreatedEventKafkaTemplate = userCreatedEventKafkaTemplate;
    }


    private void publishToJobSeeker(SagaRoot<AbstractDomainEvent<UserRoot>> sagaRoot) {
        var root = sagaRoot.getData().getRoot();
        var payload = UserCreatedEventPayload.of(root.getRootID().getAbsoluteID(), root.getUserType());
        var wrappedPayload = new SagaRoot<UserCreatedEventPayload>(sagaRoot.getSagaID(),sagaRoot.getSagaStatus(),sagaRoot.getTime(),payload);
        this.userCreatedEventKafkaTemplate.send("job-seeker-created", wrappedPayload);
    }


    public void publishCompany(SagaRoot<AbstractDomainEvent<UserRoot>> sagaRoot) {
        var root = sagaRoot.getData().getRoot();
        var payload = UserCreatedEventPayload.of(root.getRootID().getAbsoluteID(), root.getUserType());
        var wrappedPayload = new SagaRoot<UserCreatedEventPayload>(sagaRoot.getSagaID(),sagaRoot.getSagaStatus(),sagaRoot.getTime(),payload);
        this.userCreatedEventKafkaTemplate.send("company-created", wrappedPayload);
    }

    @Override
    public void publish(SagaRoot<AbstractDomainEvent<UserRoot>> sagaRoot) {
        if (sagaRoot.getData() instanceof JobSeekerCreatedEvent) this.publishToJobSeeker(sagaRoot);
        else if (sagaRoot.getData() instanceof CompanyCreatedEvent) this.publishCompany(sagaRoot);
        else throw new RuntimeException("Unknown event type");
    }

}
