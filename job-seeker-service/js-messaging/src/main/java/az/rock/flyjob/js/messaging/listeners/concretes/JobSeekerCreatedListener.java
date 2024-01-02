package az.rock.flyjob.js.messaging.listeners.concretes;

import az.rock.flyjob.js.messaging.listeners.abstracts.AbstractUserCreatedMessageListener;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class JobSeekerCreatedListener implements AbstractUserCreatedMessageListener {
    private final ObjectMapper objectMapper;

    public JobSeekerCreatedListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    @KafkaListener(topics = "${topic.js.created.name}", groupId = "company-command-consumer")
    public void listenJobSeekerCreatedEvent(JsonNode node) {
        log.info("Job seeker created event received: {}", node.toString());
        SagaStartedProcess<JobSeekerCreatedEvent> process = this.objectMapper.convertValue(node, new TypeReference<SagaStartedProcess<JobSeekerCreatedEvent>>() {
        });

    }
}
