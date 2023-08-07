package az.rock.lib.event.saga;

import az.rock.lib.annotation.ValueFace;
import az.rock.lib.event.DomainEvent;

@ValueFace
public interface SagaStep<T,S extends DomainEvent,U extends DomainEvent> {
    S process(T data);
    U rollback(T data);
}