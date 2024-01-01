package com.intellibucket.onnetwork.company.domain.presentation.command.coordinator.concretes;

import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import com.intellibucket.onnetwork.company.domain.presentation.command.coordinator.abstracts.AbstractCompanyCreatedResponseEventCoordinator;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyCommandDomainPresentationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompanyCreatedResponseEventCoordinator extends AbstractCompanyCreatedResponseEventCoordinator {
    @Value(value = "${topic.cmp.created.name}")
    private String companyCreatedTopicName;

    private final AbstractCompanyCommandDomainPresentationService companyCommandDomainPresentationService;

    public CompanyCreatedResponseEventCoordinator(AbstractCompanyCommandDomainPresentationService companyCommandDomainPresentationService) {
        this.companyCommandDomainPresentationService = companyCommandDomainPresentationService;
    }


    public String getSuccessTopic() {
        return this.companyCreatedTopicName.replace(".str", ".success");
    }

    public String getFailTopic() {
        return this.companyCreatedTopicName.replace(".str", ".fail");
    }


    @Override
    public void apply(SagaStartedProcess<CompanyCreatedEvent> sagaProcess) throws JDomainException {
        log.info("Company created event received: {}", sagaProcess.getEvent().getPayload().toString());
        CompanyRegistrationPayload payload = sagaProcess.getEvent().getPayload();
        this.companyCommandDomainPresentationService.createCompany(payload);
    }

    @Override
    protected void onFail(AbstractSagaProcess<CompanyCreatedEvent> sagaProcess, JDomainException exception) {

    }

    @Override
    protected void onError(AbstractSagaProcess<CompanyCreatedEvent> sagaProcess, Throwable throwable) {

    }
}
