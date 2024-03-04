package az.rock.flyjob.js.messaging.publishers.concretes;

import az.rock.flyjob.js.domain.presentation.ports.output.publisher.AbstractJobSeekerResponseMessagePublisher;
import com.fasterxml.jackson.databind.JsonNode;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobSeekerResponseMessagePublisher implements AbstractJobSeekerResponseMessagePublisher {

    private final KafkaTemplate<String, JsonNode> kafkaTemplate;

    public JobSeekerResponseMessagePublisher(KafkaTemplate<String, JsonNode> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(String topic, AbstractSagaProcess<?> abstractSagaProcess) {
        this.kafkaTemplate.send(topic, abstractSagaProcess.toJsonNode());
    }
}
