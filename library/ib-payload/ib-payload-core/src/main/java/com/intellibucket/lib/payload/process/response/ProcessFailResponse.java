package com.intellibucket.lib.payload.process.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intellibucket.lib.payload.process.OperationStatus;

import java.util.List;
import java.util.UUID;

public class ProcessFailResponse extends ProcessResponse {
    private List<String> errors;

    public ProcessFailResponse() {
    }

    public ProcessFailResponse(UUID transactionId, String step) {
        this(transactionId, step, List.of());
    }

    public ProcessFailResponse(UUID transactionId, String step, List<String> errors) {
        super(transactionId, step, OperationStatus.FAILED);
        this.errors = errors;
    }

    @JsonIgnore
    public Boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
