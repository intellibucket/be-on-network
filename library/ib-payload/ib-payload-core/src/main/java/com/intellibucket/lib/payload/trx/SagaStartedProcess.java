package com.intellibucket.lib.payload.trx;

import java.util.UUID;

public final class SagaStartedProcess<T> extends AbstractSagaProcess<T> {
    public SagaStartedProcess(UUID transactionId, TrxProcessStatus trxProcessStatus, Enum<?> step, T event) {
        super(transactionId, trxProcessStatus, step, event);
    }

}
