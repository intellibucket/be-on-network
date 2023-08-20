package az.rock.lib.event;

import az.rock.lib.event.impl.abstracts.JsonTypeReference;

public abstract class AbstractDomainEvent<D> implements DomainEvent<D> , JsonTypeReference {
    private final D data;

    protected AbstractDomainEvent(D data) {
        this.data = data;
    }

    public D payload() {
        return data;
    }
}
