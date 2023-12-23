package com.intellibucket.lib.payload.publisher;

import com.intellibucket.lib.payload.trx.SagaProcess;


public interface AbstractMessagePublisher<E> {
    void publish(SagaProcess<E> sagaProcess);
}
