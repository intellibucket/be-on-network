package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.coordinator.responsive.abstracts;

import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.coordinator.AbstractEventResponseCoordinator;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public abstract class AbstractCompanyCreatedResponseEventCoordinator extends AbstractEventResponseCoordinator<CompanyRegistrationPayload, CompanyCreatedEvent> {
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public abstract void apply(SagaStartedProcess<CompanyCreatedEvent> sagaProcess) throws JDomainException;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected abstract void onFail(AbstractSagaProcess<CompanyCreatedEvent> sagaProcess, JDomainException exception);

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected abstract void onError(AbstractSagaProcess<CompanyCreatedEvent> sagaProcess, Throwable throwable);


}
