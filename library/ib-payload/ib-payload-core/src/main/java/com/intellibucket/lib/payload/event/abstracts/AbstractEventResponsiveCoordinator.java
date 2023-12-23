package com.intellibucket.lib.payload.event.abstracts;


import com.intellibucket.lib.payload.trx.SagaProcess;

public abstract class AbstractEventResponsiveCoordinator<E extends AbstractDomainEvent> {

    public final void coordinate(SagaProcess<E> sagaProcess) {
        try {
            if (sagaProcess.isOnSuccess()) this.apply(sagaProcess);
            else this.fail(sagaProcess);
        } catch (Exception exception) {
            exception.printStackTrace();
            this.onError(exception, sagaProcess);
        }
    }

    protected abstract void onError(Exception exception, SagaProcess<E> sagaProcess);

    public abstract <F> void fail(SagaProcess<F> sagaProcess);

    public abstract <S> void apply(SagaProcess<S> sagaProcess);
}
