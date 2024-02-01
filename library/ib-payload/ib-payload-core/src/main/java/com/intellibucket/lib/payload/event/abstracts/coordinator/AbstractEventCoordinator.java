package com.intellibucket.lib.payload.event.abstracts.coordinator;


import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Slf4j
public abstract class AbstractEventCoordinator<E extends AbstractDomainEvent> {

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

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    protected void saveOutBox(AbstractSagaProcess<E> sagaProcess) {
        log.info("Save Outbox {} {} {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
    }

    /**
     * This method is used to proceed the event.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    protected abstract void proceed(AbstractSagaProcess<E> sagaProcess);


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void successProcess(AbstractSagaProcess<? extends AbstractSuccessDomainEvent<? extends Payload>> sagaProcess) {
        log.info("Success Process {} {} {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
        //TODO: Save Outbox
        this.onSuccess(sagaProcess);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void failProcess(AbstractSagaProcess<? extends AbstractFailDomainEvent<? extends Payload>> sagaProcess) {
        log.info("Fail Process {} {} {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
        //TODO: Save Outbox
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
