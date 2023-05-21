package az.rock.lib.event.publisher;

import az.rock.lib.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent<T>> {

    void publish(T domainEvent);
}
