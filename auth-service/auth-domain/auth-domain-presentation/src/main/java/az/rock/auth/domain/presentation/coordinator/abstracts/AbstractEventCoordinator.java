package az.rock.auth.domain.presentation.coordinator.abstracts;

import az.rock.lib.event.AbstractDomainEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractEventCoordinator<E extends AbstractDomainEvent> {

    public final void coordinate(E event){
        try {
            this.proceed(event);
        }catch (Exception exception){
            exception.printStackTrace();
            this.onError(exception,event);
        }
    }

    protected abstract void proceed(E event);
    protected abstract void onError(Exception exception, E event);
    protected abstract void onFail(AbstractDomainEvent<?> domainEvent);
    protected abstract void onSuccess(AbstractDomainEvent<?> domainEvent);
}
