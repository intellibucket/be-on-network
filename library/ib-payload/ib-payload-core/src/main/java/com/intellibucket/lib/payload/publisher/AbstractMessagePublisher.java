package com.intellibucket.lib.payload.publisher;

import com.intellibucket.lib.payload.trx.AbstractSagaProcess;


public interface AbstractMessagePublisher<E> {
    default void publish(AbstractSagaProcess<E> sagaProcess, String topic) {
        throw new UnsupportedOperationException("publish method must be implemented");
    }

    default void publish(AbstractSagaProcess<E> sagaProcess) {
        throw new UnsupportedOperationException("publish method must be implemented");
    }
}
