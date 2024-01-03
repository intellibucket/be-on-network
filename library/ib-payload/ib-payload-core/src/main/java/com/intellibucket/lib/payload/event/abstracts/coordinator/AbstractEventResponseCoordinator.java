package com.intellibucket.lib.payload.event.abstracts.coordinator;


import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaFailedProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.BiConsumer;

public abstract class AbstractEventResponseCoordinator<P, E extends AbstractDomainEvent<? super P>> {

    protected abstract String getTopic();

    protected abstract Enum<?> getStep();

    protected String getSuccessTopic() {
        return this.getTopic().replace(".str", ".success");
    }

    protected String getFailTopic() {
        return this.getTopic().replace(".str", ".fail");
    }

    protected abstract BiConsumer<String, AbstractSagaProcess<?>> consumer();

    public final void coordinate(SagaStartedProcess<E> sagaProcess) {
        try {
            var successEvent = this.execute(sagaProcess);
            this.onSuccess(sagaProcess, successEvent);
        } catch (JDomainException exception) {
            exception.printStackTrace();
            this.onFail(sagaProcess, exception);
        } catch (Exception exception) {
            exception.printStackTrace();
            this.onFail(sagaProcess);
            this.onError(sagaProcess, exception);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    protected void onSuccess(SagaStartedProcess<E> sagaProcess, AbstractSuccessDomainEvent<?> successEvent) {
        var successSagaProcess =
                AbstractSagaProcess.onSuccess(sagaProcess, this.getStep(), successEvent);
        this.consumer().accept(this.getSuccessTopic(), successSagaProcess);
    }

    protected void onError(AbstractSagaProcess<E> sagaProcess, Throwable throwable) {
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void onFail(AbstractSagaProcess<E> sagaProcess, JDomainException exception) {
        var failSagaProcess = new SagaFailedProcess<>(sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getEvent(), List.of());
        this.consumer().accept(this.getFailTopic(), failSagaProcess);
    }

    protected void onFail(AbstractSagaProcess<E> sagaProcess) {
        var message = "Failed to process saga process on : " + sagaProcess.getTransactionId() + " on step : " + sagaProcess.getStep();
        this.onFail(sagaProcess, new JDomainException(message));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public abstract AbstractSuccessDomainEvent<?> execute(SagaStartedProcess<E> sagaProcess) throws JDomainException;
}
