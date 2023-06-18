package az.rock.lib.event.publisher;

import az.rock.lib.valueObject.SagaRoot;


public interface AbstractMessagePublisher<E> {
    void publish(SagaRoot<E> sagaRoot);
}
