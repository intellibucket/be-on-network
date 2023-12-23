package az.rock.flyjob.auth.messaging.publisher;


import az.rock.auth.domain.presentation.ports.output.publisher.AbstractProfilePictureMessagePublisher;
import az.rock.flyjob.auth.model.root.user.ProfilePictureRoot;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.trx.SagaProcess;
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
    public void publish(SagaProcess<AbstractDomainEvent<ProfilePictureRoot>> sagaProcessRoot) {
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
