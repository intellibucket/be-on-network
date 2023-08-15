package az.rock.lib.event.publisher;

import az.rock.lib.event.trx.Saga;
import az.rock.lib.valueObject.SagaRoot;


public interface AbstractMessagePublisher<E> {
    void publish(Saga<E> saga);
}
