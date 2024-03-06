package az.rock.auth.domain.presentation.ports.output.repository.outbox;

import az.rock.lib.coordinator.outbox.FailOutboxRoot;
import az.rock.lib.domain.TransactionID;

import java.util.List;

public interface AbstractFailOutboxRepositoryAdapter {
    void persist(FailOutboxRoot root);

    List<FailOutboxRoot> findByTransactionId(TransactionID transactionId);
}
