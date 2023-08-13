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
            this.error();
        }
    }
    protected abstract void proceed(E event);
    protected abstract void error();
    protected abstract void onFail();
    protected abstract void onSuccess();
}
