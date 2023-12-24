package az.rock.auth.domain.presentation.ports.output.repository.outbox;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.domain.outbox.ProcessOutboxRoot;

import java.util.UUID;

public interface AbstractUserOutboxRepositoryAdapter {
    void save(ProcessOutboxRoot<RootID<UUID>> outbox);

    void success(TransactionID transactionId);

    void fail(TransactionID transactionId);

    void processing(TransactionID transactionId);

    void compensating(TransactionID transactionId);

    void compensated(TransactionID transactionId);
}
