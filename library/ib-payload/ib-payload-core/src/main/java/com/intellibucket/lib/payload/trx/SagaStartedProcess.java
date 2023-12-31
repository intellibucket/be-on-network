package com.intellibucket.lib.payload.trx;

import java.util.UUID;

public final class SagaStartedProcess<T> extends AbstractSagaProcess<T> {

    public SagaStartedProcess() {
        super();
    }

    public SagaStartedProcess(UUID transactionId, Enum<?> step, T event) {
        super(transactionId, TrxProcessStatus.STARTED, step, event);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
