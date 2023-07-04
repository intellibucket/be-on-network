package az.rock.flyjob.auth.messaging.listener;

import az.rock.lib.valueObject.SagaRoot;
import com.fasterxml.jackson.databind.JsonNode;
import model.auth.registration.CompanyRegistrationPayload;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationApprovalConsumer implements KafkaConsumer<SagaRoot<CompanyRegistrationPayload>>{
    @Override
    public <P extends SagaRoot<CompanyRegistrationPayload>> P consume(JsonNode record) {
        return null;
    }
}
