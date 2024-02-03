package az.rock.auth.domain.presentation.ports.output.repository.outbox;

import az.rock.lib.coordinator.outbox.ProcessOutboxRoot;
import az.rock.lib.domain.TransactionID;

public interface AbstractProcessOutboxRepositoryAdapter {
    void persist(ProcessOutboxRoot outbox);

    void complete(TransactionID transactionId, String step);

    void fail(TransactionID transactionId, String step);

}
