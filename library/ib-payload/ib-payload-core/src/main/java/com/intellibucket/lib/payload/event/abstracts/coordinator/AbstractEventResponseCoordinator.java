package com.intellibucket.lib.payload.event.abstracts.coordinator;


import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.concretes.FailDomainEvent;
import com.intellibucket.lib.payload.payload.FailPayload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaFailedProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

@Slf4j
public abstract class AbstractEventResponseCoordinator<P, E extends AbstractDomainEvent<? super P>> {

    protected abstract String getStartTopic();

    protected abstract String getSuccessTopic();

    protected abstract String getFailTopic();

    protected abstract Enum<?> getStep();


    protected abstract BiConsumer<String, AbstractSagaProcess<?>> endAction();

    public final void coordinate(SagaStartedProcess<E> sagaProcess) {
        log.info("Started to coordinate saga process on : " + sagaProcess.getTransactionId() + " on step : " + this.getStep());
        try {
            var successEvent = this.execute(sagaProcess);
            this.onSuccess(sagaProcess, successEvent);
        } catch (JDomainException exception) {
            log.error("Failed to process saga process on : " + sagaProcess.getTransactionId() + " on step : " + this.getStep(), exception);
            this.onFail(sagaProcess, exception);
        } catch (Exception exception) {
            log.error("Error to process saga process on : " + sagaProcess.getTransactionId() + " on step : " + this.getStep(), exception);
            this.onFail(sagaProcess);
            this.onError(sagaProcess, exception);
        }
        log.info("Finished to coordinate saga process on : " + sagaProcess.getTransactionId() + " on step : " + this.getStep());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    protected void onSuccess(SagaStartedProcess<E> sagaProcess, AbstractSuccessDomainEvent<?> successEvent) {
        if (Objects.nonNull(successEvent)) {
            var successSagaProcess = AbstractSagaProcess.onSuccess(sagaProcess, this.getStep(), successEvent);
            this.endAction().accept(this.getSuccessTopic(), successSagaProcess);
            log.info("Successfully coordinated saga process on : " + sagaProcess.getTransactionId() + " on step : " + this.getStep());
        } else throw new RuntimeException("Success event is null");
    }

    protected void onError(AbstractSagaProcess<E> sagaProcess, Throwable throwable) {
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void onFail(AbstractSagaProcess<E> sagaProcess, JDomainException exception) {
        log.error("Failed to process saga process on : " + sagaProcess.getTransactionId() + " on step : " + this.getStep(), exception);
        var failEvent = new FailDomainEvent(new FailPayload(List.of(exception.getMessage())));
        var failSagaProcess = new SagaFailedProcess<>(sagaProcess.getTransactionId(), this.getStep(), failEvent, List.of());
        this.endAction().accept(this.getFailTopic(), failSagaProcess);
    }

    protected void onFail(AbstractSagaProcess<E> sagaProcess) {
        var message = "Failed to process saga process on : " + sagaProcess.getTransactionId() + " on step : " + this.getStep();
        this.onFail(sagaProcess, new JDomainException(message));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public abstract AbstractSuccessDomainEvent<?> execute(SagaStartedProcess<E> sagaProcess) throws JDomainException;
}
