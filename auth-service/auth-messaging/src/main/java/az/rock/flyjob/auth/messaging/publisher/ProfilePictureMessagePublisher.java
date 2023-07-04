package az.rock.flyjob.auth.messaging.publisher;


import az.rock.auth.domain.presentation.ports.output.publisher.AbstractProfilePictureMessagePublisher;
import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.valueObject.SagaRoot;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.auth.ProfilePictureCreatedPayload;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProfilePictureMessagePublisher implements AbstractProfilePictureMessagePublisher {
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, JsonNode> kafkaTemplate;

    public ProfilePictureMessagePublisher(ObjectMapper objectMapper,
                                          KafkaTemplate<String, JsonNode> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public void publish(SagaRoot<AbstractDomainEvent<ProfilePictureRoot>> sagaRoot) {
        try {
            var root = sagaRoot.getData().getRoot();
            var payload = SagaRoot.of(ProfilePictureCreatedPayload.of(root.getRootID().getRootID(), root.getRootID().getRootID(), "jpg"));
            var message = objectMapper.convertValue(payload, JsonNode.class);
            this.kafkaTemplate.send("auth.profilePicture.created", message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
