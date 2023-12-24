package com.intellibucket.lib.payload.publisher;

import com.intellibucket.lib.payload.trx.AbstractSagaProcess;


public interface AbstractMessagePublisher<E> {
    void publish(AbstractSagaProcess<E> sagaProcess);
}
