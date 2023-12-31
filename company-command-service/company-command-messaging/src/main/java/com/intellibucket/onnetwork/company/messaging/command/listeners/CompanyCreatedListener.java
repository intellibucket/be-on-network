package com.intellibucket.onnetwork.company.messaging.command.listeners;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyCommandDomainPresentationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompanyCreatedListener {
    private final AbstractCompanyCommandDomainPresentationService companyCommandDomainPresentationService;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public CompanyCreatedListener(AbstractCompanyCommandDomainPresentationService companyCommandDomainPresentationService) {
        this.companyCommandDomainPresentationService = companyCommandDomainPresentationService;
    }

    @KafkaListener(topics = "${topic.cmp.created.name}", groupId = "company-command-consumer")
    public void consume(JsonNode node) {
        log.info("Company created event received: {}", node.toString());
        SagaStartedProcess<CompanyCreatedEvent> process = OBJECT_MAPPER.convertValue(node, SagaStartedProcess.class);
        this.companyCommandDomainPresentationService.createCompany(process);
    }


}
