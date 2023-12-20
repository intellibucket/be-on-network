package com.intellibucket.lib.payload.process.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intellibucket.lib.payload.process.OperationStatus;

import java.util.UUID;

public class ProcessSuccessResponse<T> extends ProcessResponse {
    private T data;

    public ProcessSuccessResponse() {
    }

    public ProcessSuccessResponse(UUID transactionId, String step) {
        this(transactionId, step, null);
    }

    public ProcessSuccessResponse(UUID transactionId, String step, T data) {
        super(transactionId, step, OperationStatus.COMPLETED);
        this.data = data;
    }

    @JsonIgnore
    public Boolean hasData() {
        return data != null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }


}
