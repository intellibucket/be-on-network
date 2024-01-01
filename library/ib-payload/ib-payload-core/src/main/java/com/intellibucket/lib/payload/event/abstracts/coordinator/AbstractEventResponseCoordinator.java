package com.intellibucket.lib.payload.event.abstracts.coordinator;


import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaFailedProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;

import java.util.List;

public abstract class AbstractEventResponseCoordinator<P, E extends AbstractDomainEvent<? super P>> {

    protected abstract String getTopic();

    protected String getSuccessTopic() {
        return this.getTopic().replace(".str", ".success");
    }

    protected String getFailTopic() {
        return this.getTopic().replace(".str", ".fail");
    }

    public final void coordinate(SagaStartedProcess<E> sagaProcess) {
        try {
            this.execute(sagaProcess);
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

    protected abstract void onFail(AbstractSagaProcess<E> sagaProcess, JDomainException exception);

    protected void onFail(AbstractSagaProcess<E> sagaProcess) {
        var failSagaProcess = new SagaFailedProcess<>(sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getEvent(), List.of());
        this.onFail(failSagaProcess, new JDomainException("Failed to process saga process on : " + sagaProcess.getTransactionId()));
    }

    public abstract void execute(SagaStartedProcess<E> sagaProcess) throws JDomainException;
}
