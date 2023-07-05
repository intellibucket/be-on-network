package az.rock.flyjob.auth.messaging.listener;

import az.rock.lib.valueObject.SagaRoot;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.auth.registration.CompanyRegistrationPayload;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationApprovalConsumer implements KafkaConsumer<SagaRoot<CompanyRegistrationPayload>>{
    private final ObjectMapper objectMapper;

    public UserRegistrationApprovalConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <P extends SagaRoot<CompanyRegistrationPayload>> P consume(JsonNode record) {
        return null;
    }

    @Override
    @KafkaListener(topics = "auth.user-registration.approval", groupId = "auth.userRegistration.approval")
    public void listen(JsonNode record) {
        var payload = this.consume(record);
    }
}
