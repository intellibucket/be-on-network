package com.intellibucket.lib.payload.publisher;

import com.intellibucket.lib.payload.trx.Saga;


public interface AbstractMessagePublisher<E> {
    void publish(Saga<E> saga);
}
