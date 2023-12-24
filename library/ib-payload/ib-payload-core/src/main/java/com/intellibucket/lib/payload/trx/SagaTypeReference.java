package com.intellibucket.lib.payload.trx;

public interface SagaTypeReference {
    default String getClassTypeReference() {
        return this.getClass().getSimpleName();
    }
}
