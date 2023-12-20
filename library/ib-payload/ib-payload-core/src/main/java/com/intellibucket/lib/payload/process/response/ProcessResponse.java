package com.intellibucket.lib.payload.process.response;

import com.intellibucket.lib.payload.process.OperationStatus;

import java.util.UUID;

public class ProcessResponse {
    private UUID transactionId;
    private String step;//The step that the process is currently in
    private OperationStatus operationStatus;//The status of the outbox record

    public ProcessResponse() {
    }

    public ProcessResponse(UUID transactionId, String step, OperationStatus operationStatus) {
        this.transactionId = transactionId;
        this.step = step;
        this.operationStatus = operationStatus;
    }


    public UUID getTransactionId() {
        return transactionId;
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public String getStep() {
        return step;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }
}
