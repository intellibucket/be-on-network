package com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.publisher;

import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;

public interface AbstractCompanyResponseMessagePublisher<T extends AbstractDomainEvent<? extends Payload>> {
    void publish(String topic, AbstractSagaProcess<T> sagaProcess);
}
