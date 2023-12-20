package com.intellibucket.lib.payload.trx;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

import java.util.Objects;
import java.util.UUID;

public final class Saga<E>{
    private UUID transactionId;
    private OutboxStatus outboxStatus;
    private E event;

    public Saga(UUID transactionId, OutboxStatus outboxStatus, E event) {
        this.transactionId = transactionId;
        this.outboxStatus = outboxStatus;
        this.event = event;
    }

    public static <E> Saga<E> of(Saga<? extends AbstractDomainEvent<?>> saga, E domainEvent){
        if (domainEvent instanceof AbstractSuccessDomainEvent<?>) return Saga.onSuccess(saga,domainEvent);
        else return Saga.onFail(saga,domainEvent);
    }

    public  static <E extends AbstractStartDomainEvent<?>> Saga<E> onProceed(E event){
        return new Saga<E>(UUID.randomUUID(), OutboxStatus.STARTED, event);
    }

    public static <E, F extends AbstractDomainEvent> Saga<? extends E> onError(Saga<E> saga) {
        return new Saga<E>(saga.getTransactionId(), OutboxStatus.FAILED, saga.getEvent());
    }

    public static <E, S> Saga<S> onFail(Saga<E> saga, S failEvent) {
        return new Saga<S>(saga.getTransactionId(), OutboxStatus.FAILED, failEvent);
    }

    public static <E, S> Saga<S> onSuccess(Saga<E> saga, S successEvent) {
        return new Saga<S>(saga.getTransactionId(), OutboxStatus.COMPLETED, successEvent);
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public OutboxStatus getState() {
        return outboxStatus;
    }

    public E getEvent() {
        return event;
    }

    @JsonIgnore
    public Boolean isOnProceed() {
        return this.outboxStatus.equals(OutboxStatus.STARTED);
    }

    @JsonIgnore
    public Boolean isOnError() {
        return this.outboxStatus.equals(OutboxStatus.FAILED);
    }
    @JsonIgnore
    public Boolean isOnFail(){
        return this.outboxStatus.equals(OutboxStatus.FAILED);
    }

    @JsonIgnore
    public Boolean isOnSuccess() {
        return this.outboxStatus.equals(OutboxStatus.COMPLETED);
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public void setState(OutboxStatus outboxStatus) {
        this.outboxStatus = outboxStatus;
    }

    public void setEvent(E event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Saga<?> that)) return false;
        return this.transactionId.compareTo(that.transactionId) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getTransactionId());
    }
}
