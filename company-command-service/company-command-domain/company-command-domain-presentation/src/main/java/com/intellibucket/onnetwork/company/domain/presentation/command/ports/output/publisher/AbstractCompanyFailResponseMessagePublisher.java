package com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.publisher;

import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.SagaFailedProcess;

public interface AbstractCompanyFailResponseMessagePublisher<T extends AbstractDomainEvent<? extends Payload>> {
    void publish(String topic, SagaFailedProcess<T> sagaProcess);
}
