package az.rock.lib.event.trx;

import az.rock.lib.event.impl.AbstractFailDomainEvent;
import az.rock.lib.event.impl.AbstractStartDomainEvent;

import java.util.Objects;
import java.util.UUID;

public final class Saga<E>{
    private final UUID transactionId;
    private final State state;
    private final E event;

    public Saga(UUID transactionId, State state , E event) {
        this.transactionId = transactionId;
        this.state = state;
        this.event = event;
    }

    public  static <E extends AbstractStartDomainEvent<?>> Saga<E> onProceed(E event){
        return new Saga<E>(UUID.randomUUID(),State.ON_PROCEED,event);
    }

    public static <E> Saga<E> onError(Saga<E> saga){
        return new Saga<E>(saga.getTransactionId(),State.ON_ERROR, saga.event);
    }

    public static <E,F extends AbstractFailDomainEvent<?>> Saga<F> onFail(Saga<E> saga, F failEvent){
        return new Saga<>(UUID.randomUUID(),State.ON_FAIL,failEvent);
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
