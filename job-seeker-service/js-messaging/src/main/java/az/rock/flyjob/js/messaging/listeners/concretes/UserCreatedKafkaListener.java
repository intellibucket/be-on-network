package az.rock.flyjob.js.messaging.listeners.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.listener.abstracts.AbstractJobSeekerCreatedEventListenerAdapter;
import az.rock.flyjob.js.messaging.listeners.abstracts.AbstractUserCreatedMessageListener;
import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.trx.Saga;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class UserCreatedKafkaListener implements AbstractUserCreatedMessageListener {
    private final AbstractJobSeekerCreatedEventListenerAdapter jobSeekerCreatedEventListener;
    private final ObjectMapper objectMapper;

    public UserCreatedKafkaListener(AbstractJobSeekerCreatedEventListenerAdapter jobSeekerCreatedEventListener,
                                    ObjectMapper objectMapper) {
        this.jobSeekerCreatedEventListener = jobSeekerCreatedEventListener;
        this.objectMapper = objectMapper;
    }

    @Override
    @KafkaListener(topics = "auth.local.js-created.str",groupId = "auth.user-created-js-group")
    public void listenJobSeekerCreatedEvent(JsonNode node) {
        try {
            var eventSaga = this.objectMapper.treeToValue(node, Saga.class);
            this.jobSeekerCreatedEventListener.consume(eventSaga);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
