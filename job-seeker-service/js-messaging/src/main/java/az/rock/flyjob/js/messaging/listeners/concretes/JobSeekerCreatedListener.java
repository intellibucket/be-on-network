package az.rock.flyjob.js.messaging.listeners.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.coordinator.abstracts.AbstractJobSeekerCreatedResponseEventCoordinator;
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

    private final AbstractJobSeekerCreatedResponseEventCoordinator jobSeekerCreatedResponseEventCoordinator;
    private final ObjectMapper objectMapper;

    public JobSeekerCreatedListener(AbstractJobSeekerCreatedResponseEventCoordinator jobSeekerCreatedResponseEventCoordinator,
                                    ObjectMapper objectMapper) {
        this.jobSeekerCreatedResponseEventCoordinator = jobSeekerCreatedResponseEventCoordinator;
        this.objectMapper = objectMapper;
    }

    @Override
    @KafkaListener(topics = "${topic.js.created.start}", groupId = "js-command-consumer")
    public void listenJobSeekerCreatedEvent(JsonNode node) {
        log.info("Job seeker created event received: {}", node.toString());
        SagaStartedProcess<JobSeekerCreatedEvent> process = this.objectMapper.convertValue(node, new TypeReference<SagaStartedProcess<JobSeekerCreatedEvent>>() {
        });
        this.jobSeekerCreatedResponseEventCoordinator.coordinate(process);
    }
}
