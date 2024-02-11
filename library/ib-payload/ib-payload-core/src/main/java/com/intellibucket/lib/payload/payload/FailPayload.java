package com.intellibucket.lib.payload.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Optional;


public class FailPayload extends Payload {
    private List<String> messages;
    private String stackTrace;

    public FailPayload() {
    }

    public FailPayload(List<String> messages) {
        this.messages = messages;
    }

    public FailPayload(List<String> messages, String stackTrace) {
        this.messages = messages;
        this.stackTrace = stackTrace;
    }

    public FailPayload(String message) {
        this.messages = List.of(message);
    }

    public Boolean hasMessage() {
        return !this.messages.isEmpty();
    }

    public Optional<String> findFirst() {
        return this.messages.stream().findFirst();
    }

    public String findFirst(String defaultMessage){
        return this.messages.stream().findFirst().orElse(defaultMessage);
    }


    public List<String> getMessages() {
        if (this.messages == null) return List.of();
        return this.messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @JsonIgnore
    public Boolean hasMessages() {
        return this.messages != null && !this.messages.isEmpty();
    }

    @JsonIgnore
    public Boolean hasStackTrace() {
        return this.stackTrace != null;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
