package com.intellibucket.lib.payload.trx;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.UUID;

public final class SagaFailedProcess<T> extends AbstractSagaProcess<T> {
    private List<String> messages;

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

    @JsonIgnore
    public Boolean hasMessages() {
        return !messages.isEmpty();
    }
}
