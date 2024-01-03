package com.intellibucket.onnetwork.company.messaging.command.publishers;

import com.fasterxml.jackson.databind.JsonNode;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.publisher.AbstractCompanyResponseMessagePublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CompanyMessagePublisher<T extends AbstractDomainEvent<? extends Payload>> implements AbstractCompanyResponseMessagePublisher<T> {
    private final KafkaTemplate<String, JsonNode> kafkaTemplate;

    public CompanyMessagePublisher(KafkaTemplate<String, JsonNode> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(String topic, AbstractSagaProcess<T> sagaProcess) {
        JsonNode message = sagaProcess.toJsonNode();
        kafkaTemplate.send(topic, message);
    }

}
