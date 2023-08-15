package az.rock.flyjob.auth.messaging.publisher;


import az.rock.auth.domain.presentation.ports.output.publisher.AbstractProfilePictureMessagePublisher;
import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.trx.Saga;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void publish(Saga<AbstractDomainEvent<ProfilePictureRoot>> sagaRoot) {
//        try {
//            var root = sagaRoot.getData().getData();
//            var payload = SagaRoot.of(ProfilePictureCreatedPayload.of(root.getUserID().getRootID(), root.getRootID().getRootID(), "jpg"));
//            var message = objectMapper.convertValue(payload, JsonNode.class);
//            this.kafkaTemplate.send("auth.profile-picture.created", message);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
