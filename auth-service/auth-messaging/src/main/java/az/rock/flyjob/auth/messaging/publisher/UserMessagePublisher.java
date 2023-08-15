package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.impl.concretes.auth.create.CompanyCreatedEvent;
import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.trx.Saga;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserMessagePublisher<S extends  AbstractDomainEvent<?>> implements AbstractUserMessagePublisher<S> {
    private final KafkaTemplate<String, JsonNode> userCreatedEventKafkaTemplate;
    private final ObjectMapper objectMapper;

    public UserMessagePublisher(KafkaTemplate<String, JsonNode> userCreatedEventKafkaTemplate,
                                ObjectMapper objectMapper) {
        this.userCreatedEventKafkaTemplate = userCreatedEventKafkaTemplate;
        this.objectMapper = objectMapper;
    }


    @Override
    public void publish(Saga<S> saga) {
        var event = saga.getEvent();
        var record = this.objectMapper.convertValue(saga,JsonNode.class);
        if (event instanceof JobSeekerCreatedEvent)
            this.userCreatedEventKafkaTemplate
                    .send("auth.job-seeker-created-event.start", record);
        else if (event instanceof CompanyCreatedEvent)
            this.userCreatedEventKafkaTemplate
                    .send("auth.company-created-event.start", record);
    }

}
