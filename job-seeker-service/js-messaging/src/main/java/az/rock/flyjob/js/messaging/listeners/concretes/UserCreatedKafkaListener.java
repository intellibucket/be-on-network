package az.rock.flyjob.js.messaging.listeners.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.listener.abstracts.AbstractJobSeekerCreatedEventListenerAdapter;
import az.rock.flyjob.js.messaging.listeners.abstracts.AbstractUserCreatedMessageListener;
import com.intellibukcet.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibukcet.lib.payload.trx.Saga;
import com.fasterxml.jackson.core.type.TypeReference;
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
        var eventSaga = this.objectMapper
                .convertValue(node, new TypeReference<Saga<JobSeekerCreatedEvent>>() {});
        this.jobSeekerCreatedEventListener.consume(eventSaga);
    }
}