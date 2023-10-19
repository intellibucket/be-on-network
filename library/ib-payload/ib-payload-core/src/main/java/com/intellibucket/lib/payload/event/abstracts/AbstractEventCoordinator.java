package com.intellibucket.lib.payload.event.abstracts;


import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.Saga;

public abstract class AbstractEventCoordinator<E extends AbstractDomainEvent> {

    public final void coordinate(Saga<E> saga){
        try {
            this.proceed(saga);
        }catch (Exception exception){
            exception.printStackTrace();
            this.onError(exception,saga);
        }
    }

    protected abstract void proceed(Saga<E> saga);
    protected abstract void onError(Exception exception, Saga<E> saga);
    public abstract <F extends AbstractFailDomainEvent<? extends Payload>> void onFail(Saga<F> saga);
    public abstract  <S extends AbstractSuccessDomainEvent<? extends Payload>> void onSuccess(Saga<S> saga);
}
