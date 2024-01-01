package com.intellibucket.onnetwork.company.messaging.command.listeners;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import com.intellibucket.onnetwork.company.domain.presentation.command.coordinator.abstracts.AbstractCompanyCreatedResponseEventCoordinator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompanyCreatedListener {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final AbstractCompanyCreatedResponseEventCoordinator companyCreatedResponseEventCoordinator;

    public CompanyCreatedListener(AbstractCompanyCreatedResponseEventCoordinator companyCreatedResponseEventCoordinator) {
        this.companyCreatedResponseEventCoordinator = companyCreatedResponseEventCoordinator;
    }


    @KafkaListener(topics = "${topic.cmp.created.name}", groupId = "company-command-consumer")
    public void consume(JsonNode node) {
        log.info("Company created event received: {}", node.toString());
        SagaStartedProcess<CompanyCreatedEvent> process = OBJECT_MAPPER.convertValue(node, new TypeReference<SagaStartedProcess<CompanyCreatedEvent>>() {
        });
        this.companyCreatedResponseEventCoordinator.coordinate(process);
    }


}
