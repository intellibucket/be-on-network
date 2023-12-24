package az.rock.auth.domain.presentation.ports.input.outbox.abstracts;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.valueObject.SagaRoot;

@InputPort
public interface AbstractOutboxInputPort<E, D> {
    SagaRoot<E> save(E event);

    void success(TransactionID transactionId);

    void fail(TransactionID transactionId);

    void processing(TransactionID transactionId);

    void compensating(TransactionID transactionId);

    void compensated(TransactionID transactionId);
}
