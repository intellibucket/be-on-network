package com.intellibucket.lib.payload.trx;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


public final class SagaProcess<E> {
    private UUID transactionId;
    private String step;
    private ProcessStatus processStatus;
    private List<String> messages;
    private E event;

    public SagaProcess(UUID transactionId, ProcessStatus processStatus, String step, E event) {
        this.transactionId = transactionId;
        this.processStatus = processStatus;
        this.event = event;
        this.step = step;
        this.messages = List.of();
    }

    public SagaProcess(UUID transactionId, ProcessStatus processStatus, String step, E event, List<String> messages) {
        this.transactionId = transactionId;
        this.processStatus = processStatus;
        this.event = event;
        this.step = step;
        this.messages = messages;
    }

    public static <E> SagaProcess<E> of(SagaProcess<? extends AbstractDomainEvent<?>> sagaProcess, Enum<?> step, E domainEvent) {
        if (domainEvent instanceof AbstractSuccessDomainEvent<?>)
            return SagaProcess.onSuccess(sagaProcess, step, domainEvent);
        else return SagaProcess.onFail(sagaProcess, step, domainEvent);
    }

    public static <E extends AbstractStartDomainEvent<?>> SagaProcess<E> onProceed(Enum<?> step, E event) {
        return new SagaProcess<E>(UUID.randomUUID(), ProcessStatus.STARTED, step.name(), event);
    }

    public static <E, F extends AbstractDomainEvent> SagaProcess<? extends E> onError(SagaProcess<E> sagaProcess) {
        return new SagaProcess<E>(sagaProcess.getTransactionId(), ProcessStatus.FAILED, sagaProcess.step, sagaProcess.getEvent());
    }

    public static <E, S> SagaProcess<S> onFail(SagaProcess<E> sagaProcess, Enum<?> step, S failEvent) {
        return SagaProcess.onFail(sagaProcess, step, failEvent, List.of());
    }

    public static <E, S> SagaProcess<S> onFail(SagaProcess<E> sagaProcess, Enum<?> step, S failEvent, List<String> errors) {
        return new SagaProcess<S>(sagaProcess.getTransactionId(), ProcessStatus.FAILED, step.name(), failEvent, errors);
    }

    public static <E, S> SagaProcess<S> onSuccess(SagaProcess<E> sagaProcess, Enum<?> step, S successEvent) {
        return new SagaProcess<S>(sagaProcess.getTransactionId(), ProcessStatus.COMPLETED, step.name(), successEvent);
    }


    @JsonIgnore
    public Boolean isOnProceed() {
        return this.processStatus.equals(ProcessStatus.STARTED);
    }

    @JsonIgnore
    public Boolean isOnError() {
        return this.processStatus.equals(ProcessStatus.FAILED);
    }

    @JsonIgnore
    public Boolean isOnFail(){
        return this.processStatus.equals(ProcessStatus.FAILED);
    }
    @JsonIgnore
    public Boolean isOnSuccess() {
        return this.processStatus.equals(ProcessStatus.COMPLETED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SagaProcess<?> that)) return false;
        return this.transactionId.compareTo(that.transactionId) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getTransactionId());
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public E getEvent() {
        return event;
    }

    public void setEvent(E event) {
        this.event = event;
    }
}
