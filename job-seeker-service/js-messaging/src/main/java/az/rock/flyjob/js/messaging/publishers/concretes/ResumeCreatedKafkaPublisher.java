package az.rock.flyjob.js.messaging.publishers.concretes;

import az.rock.flyjob.js.messaging.publishers.abstracts.AbstractResumeCreatedMessagePublisher;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ResumeCreatedKafkaPublisher implements AbstractResumeCreatedMessagePublisher {
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, JsonNode> kafkaTemplate;

    public ResumeCreatedKafkaPublisher(ObjectMapper objectMapper,
                                       KafkaTemplate<String, JsonNode> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }
}
