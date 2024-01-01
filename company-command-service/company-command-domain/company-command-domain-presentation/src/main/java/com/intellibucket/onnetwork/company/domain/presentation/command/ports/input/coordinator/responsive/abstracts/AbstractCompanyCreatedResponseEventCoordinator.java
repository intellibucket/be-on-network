package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.coordinator.responsive.abstracts;

import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.coordinator.AbstractEventResponseCoordinator;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.outbox.CompanyRegistrationSteps;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaFailedProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.publisher.AbstractCompanyFailResponseMessagePublisher;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public abstract class AbstractCompanyCreatedResponseEventCoordinator extends AbstractEventResponseCoordinator<CompanyRegistrationPayload, CompanyCreatedEvent> {

    private final AbstractCompanyFailResponseMessagePublisher companyFailResponseMessagePublisher;

    protected AbstractCompanyCreatedResponseEventCoordinator(AbstractCompanyFailResponseMessagePublisher companyFailResponseMessagePublisher) {
        this.companyFailResponseMessagePublisher = companyFailResponseMessagePublisher;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public abstract void execute(SagaStartedProcess<CompanyCreatedEvent> sagaProcess) throws JDomainException;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void onFail(AbstractSagaProcess<CompanyCreatedEvent> sagaProcess, JDomainException exception) {
        var failedSagaProcess = SagaFailedProcess.onFail(sagaProcess, CompanyRegistrationSteps.CREATING_COMPANY_PROFILE);
        this.companyFailResponseMessagePublisher.publish(this.getFailTopic(), failedSagaProcess);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected abstract void onError(AbstractSagaProcess<CompanyCreatedEvent> sagaProcess, Throwable throwable);


}
