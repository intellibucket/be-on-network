package az.rock.lib.coordinator;


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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

@Slf4j
public abstract class AbstractEventResponseCoordinator<P, E extends AbstractDomainEvent<? super P>> {

    protected abstract String getStartTopic();

    protected abstract String getSuccessTopic();

    protected abstract String getFailTopic();


    protected abstract ProcessProperty getProcessProperty();


    protected abstract BiConsumer<String, AbstractSagaProcess<?>> endAction();

    public final void coordinate(SagaStartedProcess<E> sagaProcess) {
        var processProperty = this.getProcessProperty();
        log.info("Started to coordinate saga process on : " + sagaProcess.getTransactionId() + " on step : " + processProperty.currentStep());
        try {
            var successEvent = this.execute(sagaProcess);
            this.onSuccess(sagaProcess, successEvent);
        } catch (JDomainException exception) {
            log.error("Failed to process saga process on : " + sagaProcess.getTransactionId() + " on step : " + processProperty.currentStep(), exception);
            this.onFail(sagaProcess, exception);
        } catch (Exception exception) {
            log.error("Error to process saga process on : " + sagaProcess.getTransactionId() + " on step : " + processProperty.currentStep(), exception);
            this.onFail(sagaProcess);
            this.onError(sagaProcess, exception);
        }
        log.info("Finished to coordinate saga process on : " + sagaProcess.getTransactionId() + " on step : " + processProperty.currentStep());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    protected void onSuccess(SagaStartedProcess<E> sagaProcess, AbstractSuccessDomainEvent<?> successEvent) {
        var processProperty = this.getProcessProperty();
        if (Objects.nonNull(successEvent)) {
            var successSagaProcess =
                    AbstractSagaProcess.onSuccess(sagaProcess, processProperty.processName(), processProperty.currentStep(), successEvent);
            this.endAction().accept(this.getSuccessTopic(), successSagaProcess);
            log.info("Successfully coordinated saga process on : " + sagaProcess.getTransactionId() + " on step : " + processProperty.currentStep());
        } else throw new RuntimeException("Success event is null");
    }

    protected void onError(AbstractSagaProcess<E> sagaProcess, Throwable throwable) {
        var processProperty = this.getProcessProperty();
        log.error("Error to process saga process on : " + sagaProcess.getTransactionId() + " on step : " + processProperty.currentStep(), throwable);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void onFail(AbstractSagaProcess<E> sagaProcess, JDomainException exception) {
        var processProperty = this.getProcessProperty();
        log.error("Failed to process saga process on : " + sagaProcess.getTransactionId() + " on step : " + processProperty.currentStep(), exception);
        var failEvent = new FailDomainEvent(new FailPayload(List.of(exception.getMessage())));
        var failSagaProcess = new SagaFailedProcess<>(
                sagaProcess.getTransactionId(),
                this.getProcessProperty().processName(),
                this.getProcessProperty().currentStep(),
                failEvent,
                List.of(exception.getMessage()),
                Arrays.toString(exception.getStackTrace())
        );
        this.endAction().accept(this.getFailTopic(), failSagaProcess);
    }

    protected void onFail(AbstractSagaProcess<E> sagaProcess) {
        var processProperty = this.getProcessProperty();
        var message = "Failed to process saga process on : " + sagaProcess.getTransactionId() + " on step : " + processProperty.currentStep();
        this.onFail(sagaProcess, new JDomainException(message));
    }

    protected void onFail(AbstractSagaProcess<E> sagaProcess, Exception exception) {
        this.onFail(sagaProcess, new RuntimeException(exception));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public abstract AbstractSuccessDomainEvent<?> execute(SagaStartedProcess<E> sagaProcess) throws JDomainException;
}
