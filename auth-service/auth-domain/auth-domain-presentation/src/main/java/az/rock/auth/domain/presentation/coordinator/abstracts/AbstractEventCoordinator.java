package az.rock.auth.domain.presentation.coordinator.abstracts;

import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.impl.abstracts.AbstractFailDomainEvent;
import az.rock.lib.event.impl.abstracts.AbstractSuccessDomainEvent;
import az.rock.lib.event.payload.Payload;
import az.rock.lib.event.trx.Saga;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
