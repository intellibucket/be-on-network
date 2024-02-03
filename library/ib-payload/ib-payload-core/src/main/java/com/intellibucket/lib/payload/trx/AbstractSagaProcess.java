package com.intellibucket.lib.payload.trx;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;

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
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private UUID transactionId;
    private String process;
    private String step;
    private TrxProcessStatus processStatus;
    private Boolean mustBeRetryableStep;
    private E event;

    public AbstractSagaProcess() {
    }

    public AbstractSagaProcess(UUID transactionId, TrxProcessStatus processStatus, Enum<?> step, E event) {
        this(transactionId, processStatus, step.name(), event);
    }

    public AbstractSagaProcess(UUID transactionId, TrxProcessStatus processStatus, String process, Enum<?> step, E event) {
        this(transactionId, processStatus, process, step.name(), event);
    }

    public AbstractSagaProcess(UUID transactionId, TrxProcessStatus processStatus, String step, E event) {
        this.transactionId = transactionId;
        this.processStatus = processStatus;
        this.event = event;
        this.process = event.getClass().getSimpleName();
        this.step = step;
        this.mustBeRetryableStep = false;
    }

    public AbstractSagaProcess(UUID transactionId, TrxProcessStatus processStatus, String process, String step, E event) {
        this.transactionId = transactionId;
        this.processStatus = processStatus;
        this.event = event;
        this.process = process;
        this.step = step;
        this.mustBeRetryableStep = false;
    }

    public static <E extends AbstractStartDomainEvent<?>> AbstractSagaProcess<E> onProceed(Enum<?> step, E event) {
        return new SagaStartedProcess<>(UUID.randomUUID(), step, event);
    }

    public static <E extends AbstractStartDomainEvent<?>> AbstractSagaProcess<E> onProceed(String process, Enum<?> step, E event) {
        return new SagaStartedProcess<>(UUID.randomUUID(), process, step, event);
    }

    public static <E> AbstractSagaProcess<? extends E> onError(AbstractSagaProcess<E> sagaProcess) {
        return AbstractSagaProcess.onError(sagaProcess, List.of());
    }

    public static <E> AbstractSagaProcess<? extends E> onError(AbstractSagaProcess<E> sagaProcess, List<String> errors) {
        return new SagaFailedProcess<>(sagaProcess.getTransactionId(), sagaProcess.step, sagaProcess.getEvent(), errors);
    }


    public static <E> SagaFailedProcess<AbstractFailDomainEvent<?>> onFail(AbstractSagaProcess<E> sagaProcess, Enum<?> step) {
        return AbstractSagaProcess.onFail(sagaProcess, step, new AbstractFailDomainEvent<>(), List.of());
    }

    public static <E> SagaFailedProcess<AbstractFailDomainEvent<?>> onFail(AbstractSagaProcess<E> sagaProcess, String process, String step) {
        return AbstractSagaProcess.onFail(sagaProcess, process, step, new AbstractFailDomainEvent<>(), List.of());
    }

    public static <E> SagaFailedProcess<AbstractFailDomainEvent<?>> onFail(AbstractSagaProcess<E> sagaProcess, Enum<?> step, AbstractFailDomainEvent<?> failEvent) {
        return AbstractSagaProcess.onFail(sagaProcess, step, failEvent, List.of());
    }

    public static <E> SagaFailedProcess<AbstractFailDomainEvent<?>> onFail(AbstractSagaProcess<E> sagaProcess, String process, String step, AbstractFailDomainEvent<?> failEvent, List<String> errors) {
        return new SagaFailedProcess<>(sagaProcess.getTransactionId(), process, step, failEvent, errors);
    }

    public static <E> SagaFailedProcess<AbstractFailDomainEvent<?>> onFail(AbstractSagaProcess<E> sagaProcess, Enum<?> step, AbstractFailDomainEvent<?> failEvent, List<String> errors) {
        return new SagaFailedProcess<>(sagaProcess.getTransactionId(), step, failEvent, errors);
    }


    public static <E, S> SagaCompletedProcess<S> onSuccess(AbstractSagaProcess<E> sagaProcess, Enum<?> step, S successEvent) {
        return new SagaCompletedProcess<>(sagaProcess.getTransactionId(), step, successEvent);
    }

    public static <E, S> SagaCompletedProcess<S> onSuccess(AbstractSagaProcess<E> sagaProcess, String process, Enum<?> step, S successEvent) {
        return new SagaCompletedProcess<>(sagaProcess.getTransactionId(), process, step, successEvent);
    }

    public static <E, S> SagaCompletedProcess<S> onSuccess(AbstractSagaProcess<E> sagaProcess, String process, String step, S successEvent) {
        return new SagaCompletedProcess<>(sagaProcess.getTransactionId(), process, step, successEvent);
    }

    @JsonIgnore
    public JsonNode toJsonNode() {
        return toJsonNode(OBJECT_MAPPER);
    }

    @JsonIgnore
    public JsonNode toJsonNode(ObjectMapper objectMapper) {
        return objectMapper.convertValue(this, JsonNode.class);
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
    public Boolean isOnFail() {
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

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
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


    @Override
    public String toString() {
        return this.getClassTypeReference() + "{" +
                "transactionId=" + transactionId +
                ", process='" + process + '\'' +
                ", step='" + step + '\'' +
                ", processStatus=" + processStatus +
                ", mustBeRetryableStep=" + mustBeRetryableStep +
                ", event=" + event +
                "}\n";
    }
}
