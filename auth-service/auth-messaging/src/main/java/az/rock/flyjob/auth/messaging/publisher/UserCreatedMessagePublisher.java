package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import com.fasterxml.jackson.databind.JsonNode;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import lombok.Data;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserCreatedMessagePublisher<S extends AbstractDomainEvent<?>> implements AbstractUserMessagePublisher<S> {

    private final KafkaTemplate<String, JsonNode> userCreatedEventKafkaTemplate;

    public UserCreatedMessagePublisher(KafkaTemplate<String, JsonNode> userCreatedEventKafkaTemplate) {
        this.userCreatedEventKafkaTemplate = userCreatedEventKafkaTemplate;
    }

    @Override
    public void publish(AbstractSagaProcess<S> sagaProcess, String topic) {
        var event = sagaProcess.getEvent();
        var record = sagaProcess.toJsonNode();
        this.userCreatedEventKafkaTemplate.send(topic, record);
    }

}
