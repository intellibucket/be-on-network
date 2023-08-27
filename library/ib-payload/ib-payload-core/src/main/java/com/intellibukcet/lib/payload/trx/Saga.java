package com.intellibukcet.lib.payload.trx;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.AbstractSuccessDomainEvent;

import java.util.Objects;
import java.util.UUID;

public final class Saga<E>{
    private UUID transactionId;
    private State state;
    private E event;

    public Saga(UUID transactionId, State state , E event) {
        this.transactionId = transactionId;
        this.state = state;
        this.event = event;
    }

    public static <E> Saga<E> of(Saga<? extends AbstractDomainEvent<?>> saga, E domainEvent){
        if (domainEvent instanceof AbstractSuccessDomainEvent<?>) return Saga.onSuccess(saga,domainEvent);
        else return Saga.onFail(saga,domainEvent);
    }

    public  static <E extends AbstractStartDomainEvent<?>> Saga<E> onProceed(E event){
        return new Saga<E>(UUID.randomUUID(),State.ON_PROCEED,event);
    }

    public static <E,F extends AbstractDomainEvent> Saga<? extends E>  onError(Saga<E> saga){
        return new Saga<E>(saga.getTransactionId(),State.ON_ERROR, saga.getEvent());
    }

    public static <E,S> Saga<S> onFail(Saga<E> saga, S failEvent){
        return new Saga<S>(saga.getTransactionId(),State.ON_FAIL, failEvent);
    }

    public static <E,S> Saga<S> onSuccess(Saga<E> saga, S successEvent){
        return new Saga<S>(saga.getTransactionId(),State.ON_SUCCESS, successEvent);
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public State getState() {
        return state;
    }

    public E getEvent() {
        return event;
    }

    @JsonIgnore
    public Boolean isOnProceed(){
        return this.state.equals(State.ON_PROCEED);
    }
    @JsonIgnore
    public Boolean isOnError(){
        return this.state.equals(State.ON_ERROR);
    }
    @JsonIgnore
    public Boolean isOnFail(){
        return this.state.equals(State.ON_FAIL);
    }
    @JsonIgnore
    public Boolean isOnSuccess(){
        return this.state.equals(State.ON_SUCCESS);
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public void setState(State state) {
        this.state = state;
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
