package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.trx.Saga;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserCreatedMessagePublisher<S extends AbstractDomainEvent<?>> implements AbstractUserMessagePublisher<S> {
    @Value(value = "${topic.js.created.name}")
    private String jsTopic;
    @Value(value = "${topic.cmp.created.name}")
    private String cmpTopic;
    private final KafkaTemplate<String, JsonNode> userCreatedEventKafkaTemplate;
    private final ObjectMapper objectMapper;

    public UserCreatedMessagePublisher(KafkaTemplate<String, JsonNode> userCreatedEventKafkaTemplate,
                                       ObjectMapper objectMapper) {
        this.userCreatedEventKafkaTemplate = userCreatedEventKafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publish(Saga<S> saga) {
        var event = saga.getEvent();
        var record = this.objectMapper.convertValue(saga,JsonNode.class);
        if (event instanceof JobSeekerCreatedEvent)
            this.userCreatedEventKafkaTemplate.send(jsTopic, record);
        else if (event instanceof CompanyCreatedEvent)
            this.userCreatedEventKafkaTemplate.send(cmpTopic, record);
    }

}
