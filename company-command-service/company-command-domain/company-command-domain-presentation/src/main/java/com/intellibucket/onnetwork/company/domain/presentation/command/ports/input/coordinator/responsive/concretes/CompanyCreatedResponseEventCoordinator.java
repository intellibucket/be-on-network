package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.coordinator.responsive.concretes;

import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.outbox.CompanyRegistrationSteps;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.coordinator.responsive.abstracts.AbstractCompanyCreatedResponseEventCoordinator;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.publisher.AbstractCompanyResponseMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Component
@Slf4j
public class CompanyCreatedResponseEventCoordinator extends AbstractCompanyCreatedResponseEventCoordinator {

    @Value(value = "${topic.cmp.created.name}")
    private String companyCreatedTopicName;

    private final AbstractCompanyCommandDomainPresentationService companyCommandDomainPresentationService;
    private final AbstractCompanyResponseMessagePublisher companyResponseMessagePublisher;

    public CompanyCreatedResponseEventCoordinator(AbstractCompanyCommandDomainPresentationService companyCommandDomainPresentationService,
                                                  AbstractCompanyResponseMessagePublisher companyFailResponseMessagePublisher) {
        this.companyCommandDomainPresentationService = companyCommandDomainPresentationService;
        this.companyResponseMessagePublisher = companyFailResponseMessagePublisher;
    }

    @Override
    protected String getTopic() {
        return this.companyCreatedTopicName;
    }

    @Override
    protected Enum<?> getStep() {
        return CompanyRegistrationSteps.CREATING_COMPANY_PROFILE;
    }

    @Override
    protected BiConsumer<String, AbstractSagaProcess<?>> consumer() {
        return companyResponseMessagePublisher::publish;
    }

    @Override
    public AbstractSuccessDomainEvent<?> execute(SagaStartedProcess<CompanyCreatedEvent> sagaProcess) throws JDomainException {
        log.info("Company created event received: {}", sagaProcess.getEvent().getPayload().toString());
        CompanyRegistrationPayload payload = sagaProcess.getEvent().getPayload();
        return this.companyCommandDomainPresentationService.createCompany(payload);
    }



}
