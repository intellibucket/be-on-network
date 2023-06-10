package az.rock.auth.domain.presentation.ports.input.outbox.abstracts;

import az.rock.lib.domain.SagaID;

import java.util.UUID;

public interface AbstractOutboxInputPort<E> {
    void save(E event);
    void success(SagaID sagaId);
    void fail(SagaID sagaId);

    void processing(SagaID sagaId);

    void compensating(SagaID sagaId);

    void compensated(SagaID sagaId);
}
