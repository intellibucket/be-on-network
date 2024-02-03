package az.rock.lib.coordinator;


import az.rock.lib.coordinator.outbox.AbstractOutboxInputPort;
import az.rock.lib.coordinator.outbox.FailOutboxRoot;
import az.rock.lib.coordinator.outbox.ProcessOutboxRoot;
import az.rock.lib.coordinator.outbox.ProcessStepRoot;
import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.valueObject.Version;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Slf4j
public abstract class AbstractEventCoordinator<E extends AbstractDomainEvent> {

    private final AbstractOutboxInputPort outboxProcess;

    protected AbstractEventCoordinator(AbstractOutboxInputPort outboxProcess) {
        this.outboxProcess = outboxProcess;
    }

    /**
     * This method is used to coordinate the event which is published by the event publisher.
     * When the event is published, the event coordinator will be notified and the coordinator will.
     * When the event cannot be published, the coordinator will be executed the onError method.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = Exception.class)
    public void coordinate(AbstractSagaProcess<E> sagaProcess) {
        this.saveOutBox(sagaProcess);
        try {
            this.proceed(sagaProcess);
        } catch (Exception exception) {
            exception.printStackTrace();
            this.onError(sagaProcess, exception);
        }
    }

    public abstract ProcessProperty getProcess();

    private String writeValueAsString(E event) {
        try {
            return new ObjectMapper().writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    protected void saveOutBox(AbstractSagaProcess<E> sagaProcess) {
        log.info("Save Outbox {} {} {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
        var eventAsJson = this.writeValueAsString(sagaProcess.getEvent());
        var proceddOutboxRoot = ProcessOutboxRoot.Builder
                .builder()
                .uuid(OutboxID.of(UUID.randomUUID()))
                .transactionId(TransactionID.of(sagaProcess.getTransactionId()))
                .version(Version.ONE)
                .isActive(true)
                .topic("unknown-topic")
                .trxStatus(sagaProcess.getProcessStatus())
                .process(this.getProcess().processName())
                .step(sagaProcess.getStep())
                .event(eventAsJson)
                .mustBeRetryableStep(true)
                .build();
        this.outboxProcess.startOutboxProcess(proceddOutboxRoot);
    }

    /**
     * This method is used to proceed the event.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    protected abstract void proceed(AbstractSagaProcess<E> sagaProcess);


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void successProcess(AbstractSagaProcess<? extends AbstractSuccessDomainEvent<? extends Payload>> sagaProcess) {
        log.info("Success Process {} {} {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
        var processStepOutboxRoot = ProcessStepRoot.Builder
                .builder()
                .uuid(OutboxID.of(UUID.randomUUID()))
                .transactionId(TransactionID.of(sagaProcess.getTransactionId()))
                .version(Version.ONE)
                .isActive(true)
                .process(this.getProcess().processName())
                .step(sagaProcess.getStep())
                .isSuccessful(true)
                .build();
        this.outboxProcess.successOutboxProcess(processStepOutboxRoot, this.getProcess().steps());
        this.onSuccess(sagaProcess);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void failProcess(AbstractSagaProcess<? extends AbstractFailDomainEvent<? extends Payload>> sagaProcess) {
        log.info("Fail Process {} {} {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
        var failOutboxRoot = FailOutboxRoot.Builder
                .builder()
                .uuid(OutboxID.of(UUID.randomUUID()))
                .transactionId(TransactionID.of(sagaProcess.getTransactionId()))
                .version(Version.ONE)
                .isActive(true)
                .process(this.getProcess().processName())
                .step(sagaProcess.getStep())
                .stackTrace("unknown-stack-trace")
                .message("unknown-message")
                .build();
        this.outboxProcess.failOutboxProcess(failOutboxRoot);
        this.onFail(sagaProcess);
    }

    /**
     * This method is used to handle the error whict cannot be proceed the event.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void onError(AbstractSagaProcess<E> sagaProcess, Exception exception) {
        log.error("Error Process {} {} {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
    }

    /**
     * This method is used to handle the fail event which executed by the event listener.
     */
    public <F extends AbstractFailDomainEvent<? extends Payload>> void onFail(AbstractSagaProcess<F> sagaProcess) {
        log.warn("Fail Process {} {} {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
        log.info("Fail Process not implemented yet");
    }

    /**
     * This method is used to handle the success event which executed by the event listener.
     */
    public <S extends AbstractSuccessDomainEvent<? extends Payload>> void onSuccess(AbstractSagaProcess<S> sagaProcess) {
        log.info("Success Process {} {} {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
        log.info("Success Process not implemented yet");
    }
}
