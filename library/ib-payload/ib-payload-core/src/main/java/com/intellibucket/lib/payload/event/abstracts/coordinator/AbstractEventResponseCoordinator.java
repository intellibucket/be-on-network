package com.intellibucket.lib.payload.event.abstracts.coordinator;


import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;

public abstract class AbstractEventResponseCoordinator<E extends AbstractDomainEvent> {

    public final void coordinate(AbstractSagaProcess<E> sagaProcess) {
        try {
            this.apply(sagaProcess);
        } catch (JDomainException exception) {
            exception.printStackTrace();
            this.onFail(sagaProcess, exception);
        } catch (Exception exception) {
            exception.printStackTrace();
            this.onFail(sagaProcess);
            this.onError(sagaProcess, exception);
        }
    }

    protected abstract void onError(AbstractSagaProcess<E> sagaProcess, Throwable throwable);

    protected abstract <F> void onFail(AbstractSagaProcess<F> sagaProcess, JDomainException exception);

    protected abstract <F> void onFail(AbstractSagaProcess<F> sagaProcess);

    public abstract <S> void apply(AbstractSagaProcess<S> sagaProcess) throws JDomainException;
}
