package com.intellibukcet.lib.payload.publisher;

import com.intellibukcet.lib.payload.trx.Saga;


public interface AbstractMessagePublisher<E> {
    void publish(Saga<E> saga);
}
