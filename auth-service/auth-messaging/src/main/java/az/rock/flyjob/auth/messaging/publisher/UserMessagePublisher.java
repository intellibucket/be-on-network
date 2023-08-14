package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import az.rock.flyjob.auth.event.user.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.user.JobSeekerCreatedEvent;
import az.rock.flyjob.auth.event.user.UserUpdatedEvent;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.valueObject.SagaRoot;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.auth.UserCreatedEventPayload;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserMessagePublisher implements AbstractUserMessagePublisher {
    private final KafkaTemplate<String, JsonNode>userCreatedEventKafkaTemplate;
    private final ObjectMapper objectMapper;

    public UserMessagePublisher(KafkaTemplate<String, JsonNode> userCreatedEventKafkaTemplate,
                                ObjectMapper objectMapper) {
        this.userCreatedEventKafkaTemplate = userCreatedEventKafkaTemplate;
        this.objectMapper = objectMapper;
    }


    private void publishToJobSeeker(SagaRoot<AbstractDomainEvent<UserRoot>> sagaRoot) {
        var root = sagaRoot.getData().getData();
        var payload = UserCreatedEventPayload.of(root.getRootID().getAbsoluteID(), root.getUserType());
        var wrappedPayload = new SagaRoot<>(sagaRoot.getSagaID(),sagaRoot.getSagaStatus(),sagaRoot.getTime(),payload);
        var record =this.objectMapper.convertValue(wrappedPayload, JsonNode.class);
        this.userCreatedEventKafkaTemplate.send("job-seeker-created", record);
    }


    public void publishCompany(SagaRoot<AbstractDomainEvent<UserRoot>> sagaRoot) {
        var root = sagaRoot.getData().getData();
        var payload = UserCreatedEventPayload.of(root.getRootID().getAbsoluteID(), root.getUserType());
        var wrappedPayload = new SagaRoot<>(sagaRoot.getSagaID(),sagaRoot.getSagaStatus(),sagaRoot.getTime(),payload);
        var record =this.objectMapper.convertValue(wrappedPayload, JsonNode.class);
        this.userCreatedEventKafkaTemplate.send("company-created", record);
    }

    public void publishUpdatedEvent(SagaRoot<AbstractDomainEvent<UserRoot>> sagaRoot) {
        //log.info("Publish UserUpdatedEvent to Kafka with Saga ID : {}", sagaRoot.getSagaID());
    }

    @Override
    public void publish(SagaRoot<AbstractDomainEvent<UserRoot>> sagaRoot) {
        if (sagaRoot.getData() instanceof JobSeekerCreatedEvent) this.publishToJobSeeker(sagaRoot);
        else if (sagaRoot.getData() instanceof CompanyCreatedEvent) this.publishCompany(sagaRoot);
        else if (sagaRoot.getData() instanceof UserUpdatedEvent) this.publishUpdatedEvent(sagaRoot);
        else throw new RuntimeException("Unknown event type");
    }

}
