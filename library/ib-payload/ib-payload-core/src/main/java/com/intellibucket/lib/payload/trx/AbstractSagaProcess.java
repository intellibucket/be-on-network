package com.intellibucket.lib.payload.trx;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "classTypeReference")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SagaStartedProcess.class, name = "SagaStartedProcess"),
        @JsonSubTypes.Type(value = SagaFailedProcess.class, name = "SagaFailedProcess"),
        @JsonSubTypes.Type(value = SagaCompletedProcess.class, name = "SagaCompletedProcess")
})
public abstract sealed class AbstractSagaProcess<E> implements SagaTypeReference
        permits SagaStartedProcess, SagaFailedProcess, SagaCompletedProcess {
    private UUID transactionId;
    private String process;
    private Enum<?> step;
    private TrxProcessStatus processStatus;
    private Boolean mustBeRetryableStep;
    private E event;

    public AbstractSagaProcess(UUID transactionId, TrxProcessStatus processStatus, Enum<?> step, E event) {
        this.transactionId = transactionId;
        this.processStatus = processStatus;
        this.event = event;
        this.process = event.getClass().getSimpleName();
        this.step = step;
    }


    public static <E> AbstractSagaProcess<E> of(AbstractSagaProcess<? extends AbstractDomainEvent<?>> sagaProcess, Enum<?> step, E domainEvent) {
        if (domainEvent instanceof AbstractSuccessDomainEvent<?>)
            return AbstractSagaProcess.onSuccess(sagaProcess, step, domainEvent);
        else return AbstractSagaProcess.onFail(sagaProcess, step, domainEvent);
    }

    public static <E extends AbstractStartDomainEvent<?>> AbstractSagaProcess<E> onProceed(Enum<?> step, E event) {
        return new SagaStartedProcess<>(UUID.randomUUID(), step, event);
    }

    public static <E> AbstractSagaProcess<? extends E> onError(AbstractSagaProcess<E> sagaProcess) {
        return AbstractSagaProcess.onError(sagaProcess, List.of());
    }

    public static <E> AbstractSagaProcess<? extends E> onError(AbstractSagaProcess<E> sagaProcess, List<String> errors) {
        return new SagaFailedProcess<>(sagaProcess.getTransactionId(), sagaProcess.step, sagaProcess.getEvent(), errors);
    }

    public static <E, S> AbstractSagaProcess<S> onFail(AbstractSagaProcess<E> sagaProcess, Enum<?> step, S failEvent) {
        return AbstractSagaProcess.onFail(sagaProcess, step, failEvent, List.of());
    }

    public static <E, S> AbstractSagaProcess<S> onFail(AbstractSagaProcess<E> sagaProcess, Enum<?> step, S failEvent, List<String> errors) {
        return new SagaFailedProcess<>(sagaProcess.getTransactionId(), step, failEvent, errors);
    }

    public static <E, S> AbstractSagaProcess<S> onSuccess(AbstractSagaProcess<E> sagaProcess, Enum<?> step, S successEvent) {
        return new SagaCompletedProcess<>(sagaProcess.getTransactionId(), step, successEvent);
    }


    @JsonIgnore
    public Boolean isOnProceed() {
        return this.processStatus.equals(TrxProcessStatus.STARTED);
    }

    @JsonIgnore
    public Boolean isOnError() {
        return this.processStatus.equals(TrxProcessStatus.FAILED);
    }

    @JsonIgnore
    public Boolean isOnFail(){
        return this.processStatus.equals(TrxProcessStatus.FAILED);
    }
    @JsonIgnore
    public Boolean isOnSuccess() {
        return this.processStatus.equals(TrxProcessStatus.COMPLETED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractSagaProcess<?> that)) return false;
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

    public Enum<?> getStep() {
        return step;
    }

    public void setStep(Enum<?> step) {
        this.step = step;
    }

    public TrxProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(TrxProcessStatus trxProcessStatus) {
        this.processStatus = trxProcessStatus;
    }

    public E getEvent() {
        return event;
    }

    public void setEvent(E event) {
        this.event = event;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Boolean getMustBeRetryableStep() {
        return mustBeRetryableStep;
    }

    public void setMustBeRetryableStep(Boolean mustBeRetryableStep) {
        this.mustBeRetryableStep = mustBeRetryableStep;
    }
}
