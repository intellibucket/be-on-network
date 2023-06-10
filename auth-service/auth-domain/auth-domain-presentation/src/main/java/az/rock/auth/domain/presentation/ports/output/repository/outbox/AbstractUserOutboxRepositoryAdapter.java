package az.rock.auth.domain.presentation.ports.output.repository.outbox;

import az.rock.flyjob.auth.root.UserOutboxRoot;
import az.rock.lib.domain.SagaID;

public interface AbstractUserOutboxRepositoryAdapter {
    void save(UserOutboxRoot outbox);
    void success(SagaID sagaId);
    void fail(SagaID sagaId);
    void processing(SagaID sagaId);
    void compensating(SagaID sagaId);
    void compensated(SagaID sagaId);
}
