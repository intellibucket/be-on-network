package com.intellibucket.onnetwork.company.domain.presentation.command.coordinator.concretes;

import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import com.intellibucket.onnetwork.company.domain.presentation.command.coordinator.abstracts.AbstractCompanyCreatedResponseEventCoordinator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompanyCreatedResponseEventCoordinator extends AbstractCompanyCreatedResponseEventCoordinator {
    @Value(value = "${topic.cmp.created.name}")
    private String companyCreatedTopicName;


    public String getSuccessTopic() {
        return this.companyCreatedTopicName.replace(".str", ".success");
    }

    public String getFailTopic() {
        return this.companyCreatedTopicName.replace(".str", ".fail");
    }


    @Override
    public <S> void apply(AbstractSagaProcess<S> sagaProcess) {
        log.info("Company created event received: {}", sagaProcess.getEvent().toString());
        this.createCompany((SagaStartedProcess<CompanyCreatedEvent>) sagaProcess);
    }

    @Override
    protected void createCompany(SagaStartedProcess<CompanyCreatedEvent> request) {
        CompanyRegistrationPayload payload = request.getEvent().getPayload();
        log.info("Company created event received: {}", payload.toString());
    }

    @Override
    protected void onError(AbstractSagaProcess<CompanyCreatedEvent> sagaProcess, Throwable throwable) {
        log.error("Error occurred while creating company: {}", throwable.getMessage());
    }

    @Override
    protected <F> void onFail(AbstractSagaProcess<F> sagaProcess) {
        log.error("Fail occurred while creating company: ");
    }


    @Override
    protected <F> void onFail(AbstractSagaProcess<F> sagaProcess, JDomainException exception) {
        log.error("Fail occurred while creating company: {}", exception.getMessage());
    }
}
