package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.coordinator.responsive.concretes;

import az.rock.lib.coordinator.ProcessProperty;
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

import java.util.Arrays;
import java.util.function.BiConsumer;

@Component
@Slf4j
public class CompanyCreatedResponseEventCoordinator extends AbstractCompanyCreatedResponseEventCoordinator {

    @Value(value = "${topic.cmp.created.start}")
    private String companyStartCreatedTopicName;

    @Value(value = "${topic.cmp.created.success}")
    private String companySuccessCreatedTopicName;

    @Value(value = "${topic.cmp.created.fail}")
    private String companyFailCreatedTopicName;

    private final AbstractCompanyCommandDomainPresentationService companyCommandDomainPresentationService;
    private final AbstractCompanyResponseMessagePublisher companyResponseMessagePublisher;

    public CompanyCreatedResponseEventCoordinator(AbstractCompanyCommandDomainPresentationService companyCommandDomainPresentationService,
                                                  AbstractCompanyResponseMessagePublisher companyFailResponseMessagePublisher) {
        this.companyCommandDomainPresentationService = companyCommandDomainPresentationService;
        this.companyResponseMessagePublisher = companyFailResponseMessagePublisher;
    }

    @Override
    protected String getStartTopic() {
        return this.companyStartCreatedTopicName;
    }

    @Override
    protected String getSuccessTopic() {
        return this.companySuccessCreatedTopicName;
    }

    @Override
    protected String getFailTopic() {
        return this.companyFailCreatedTopicName;
    }

    @Override
    protected ProcessProperty getProcessProperty() {
        return new ProcessProperty(
                CompanyRegistrationSteps.COMPANY_PROFILE_CREATING_STEP.getProcessName(),
                CompanyRegistrationSteps.COMPANY_PROFILE_CREATING_STEP.name(),
                Arrays.stream(CompanyRegistrationSteps.values()).map(Enum::name).toList());
    }

    @Override
    protected BiConsumer<String, AbstractSagaProcess<?>> endAction() {
        return companyResponseMessagePublisher::publish;
    }

    @Override
    public AbstractSuccessDomainEvent<?> execute(SagaStartedProcess<CompanyCreatedEvent> sagaProcess) throws JDomainException {
        log.info("Company created event received: {}", sagaProcess.getEvent().getPayload().toString());
        CompanyRegistrationPayload payload = sagaProcess.getEvent().getPayload();
        return this.companyCommandDomainPresentationService.createCompany(payload);
    }

}
