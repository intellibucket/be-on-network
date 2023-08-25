package com.intellibukcet.lib.payload.event.abstracts;


import com.intellibukcet.lib.payload.trx.Saga;

public abstract class AbstractEventResponsiveCoordinator<E extends AbstractDomainEvent> {

    public final void coordinate(Saga<E> saga){
        try {
            if (saga.isOnSuccess()) this.apply(saga);
            else this.fail(saga);
        }catch (Exception exception){
            exception.printStackTrace();
            this.onError(exception,saga);
        }
    }

    protected abstract void onError(Exception exception, Saga<E> saga);
    public abstract <F> void fail(Saga<F> saga);
    public abstract  <S> void apply(Saga<S> saga);
}
