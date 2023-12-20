package com.intellibucket.onnetwork.vacancy.domain.presentation.command.dto.abstracts;

public class CreateRequest<T> {
    private T model;

    public CreateRequest(T model) {
        this.model = model;
    }

    public CreateRequest() {
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

}
