package com.intellibucket.lib.payload.event.abstracts;


import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;

public abstract class AbstractEventCoordinator<E extends AbstractDomainEvent> {

    /**
     * This method is used to coordinate the event which is published by the event publisher.
     * When the event is published, the event coordinator will be notified and the coordinator will.
     * When the event cannot be published, the coordinator will be executed the onError method.
     */
    public final void coordinate(AbstractSagaProcess<E> sagaProcess) {
        this.saveOutBox(sagaProcess);
        try {
            this.proceed(sagaProcess);
        } catch (Exception exception) {
            exception.printStackTrace();
            this.onError(sagaProcess, exception);
        }
    }

    protected void saveOutBox(AbstractSagaProcess<E> sagaProcess) {

    }

    /**
     * This method is used to proceed the event.
     */
    protected abstract void proceed(AbstractSagaProcess<E> sagaProcess);


    /**
     * This method is used to handle the error whict cannot be proceed the event.
     */
    protected void onError(AbstractSagaProcess<E> sagaProcess, Exception exception) {

    }

    /**
     * This method is used to handle the fail event which executed by the event listener.
     */
    public abstract <F extends AbstractFailDomainEvent<? extends Payload>> void onFail(AbstractSagaProcess<F> sagaProcess);

    /**
     * This method is used to handle the success event which executed by the event listener.
     */
    public abstract <S extends AbstractSuccessDomainEvent<? extends Payload>> void onSuccess(AbstractSagaProcess<S> sagaProcess);
}
