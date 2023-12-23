package com.intellibucket.lib.payload.event.abstracts;


import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.SagaProcess;

public abstract class AbstractEventCoordinator<E extends AbstractDomainEvent> {

    /**
     * This method is used to coordinate the event which is published by the event publisher.
     * When the event is published, the event coordinator will be notified and the coordinator will.
     * When the event cannot be published, the coordinator will be executed the onError method.
     */
    public final void coordinate(SagaProcess<E> sagaProcess) {
        try {
            this.proceed(sagaProcess);
        } catch (Exception exception) {
            exception.printStackTrace();
            this.onError(sagaProcess, exception);
        }
    }

    /**
     * This method is used to proceed the event.
     */
    protected abstract void proceed(SagaProcess<E> sagaProcess);

    /**
     * This method is used to handle the error.
     */
    protected abstract void onError(SagaProcess<E> sagaProcess, Exception exception);

    /**
     * This method is used to handle the fail event which executed by the event listener.
     */
    public abstract <F extends AbstractFailDomainEvent<? extends Payload>> void onFail(SagaProcess<F> sagaProcess);

    /**
     * This method is used to handle the success event which executed by the event listener.
     */
    public abstract <S extends AbstractSuccessDomainEvent<? extends Payload>> void onSuccess(SagaProcess<S> sagaProcess);
}
