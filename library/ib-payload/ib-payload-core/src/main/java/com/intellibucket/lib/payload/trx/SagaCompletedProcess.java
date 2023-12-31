package com.intellibucket.lib.payload.trx;

import java.util.UUID;

public final class SagaCompletedProcess<T> extends AbstractSagaProcess<T> {

    public SagaCompletedProcess() {
        super();
    }

    public SagaCompletedProcess(UUID transactionId, Enum<?> step, T event) {
        super(transactionId, TrxProcessStatus.COMPLETED, step, event);
    }


}
