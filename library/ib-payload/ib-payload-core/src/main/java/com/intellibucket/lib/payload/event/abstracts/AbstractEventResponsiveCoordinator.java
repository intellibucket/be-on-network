package com.intellibucket.lib.payload.event.abstracts;


import com.intellibucket.lib.payload.trx.AbstractSagaProcess;

public abstract class AbstractEventResponsiveCoordinator<E extends AbstractDomainEvent> {

    public final void coordinate(AbstractSagaProcess<E> sagaProcess) {
        try {
            if (sagaProcess.isOnSuccess()) this.apply(sagaProcess);
            else this.fail(sagaProcess);
        } catch (Exception exception) {
            exception.printStackTrace();
            this.onError(exception, sagaProcess);
        }
    }

    protected abstract void onError(Exception exception, AbstractSagaProcess<E> sagaProcess);

    public abstract <F> void fail(AbstractSagaProcess<F> sagaProcess);

    public abstract <S> void apply(AbstractSagaProcess<S> sagaProcess);
}
