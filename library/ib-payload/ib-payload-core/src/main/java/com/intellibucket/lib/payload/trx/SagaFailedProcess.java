package com.intellibucket.lib.payload.trx;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.UUID;

public final class SagaFailedProcess<T> extends AbstractSagaProcess<T> {
    private List<String> messages;

    private String stackTrace;

    public SagaFailedProcess() {
        super();
    }

    public SagaFailedProcess(UUID transactionId, Enum<?> step, T event) {
        this(transactionId, step, event, List.of());
    }

    public SagaFailedProcess(UUID transactionId, Enum<?> step, T event, List<String> messages) {
        super(transactionId, TrxProcessStatus.FAILED, step, event);
        this.messages = messages;
    }

    public SagaFailedProcess(UUID transactionId, String process, Enum<?> step, T event, List<String> messages) {
        this(transactionId, process, step, event, messages, null);
    }

    public SagaFailedProcess(UUID transactionId, String process, Enum<?> step, T event, List<String> messages, String stackTrace) {
        super(transactionId, TrxProcessStatus.FAILED, process, step, event);
        this.messages = messages;
        this.stackTrace = stackTrace;
    }

    public SagaFailedProcess(UUID transactionId, String process, String step, T event, List<String> messages) {
        this(transactionId, process, step, event, messages, null);
    }

    public SagaFailedProcess(UUID transactionId, String process, String step, T event, List<String> messages, String stackTrace) {
        super(transactionId, TrxProcessStatus.FAILED, process, step, event);
        this.messages = messages;
        this.stackTrace = stackTrace;
    }

    public SagaFailedProcess(UUID transactionId, String step, T event, List<String> messages) {
        super(transactionId, TrxProcessStatus.FAILED, step, event);
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @JsonIgnore
    public Boolean hasStackTrace() {
        return stackTrace != null;
    }

    @JsonIgnore
    public Boolean hasMessages() {
        return !messages.isEmpty();
    }
}
