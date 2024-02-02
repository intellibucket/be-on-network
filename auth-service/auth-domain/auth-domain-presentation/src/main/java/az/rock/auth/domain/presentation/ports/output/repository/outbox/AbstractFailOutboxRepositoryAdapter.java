package az.rock.auth.domain.presentation.ports.output.repository.outbox;

import az.rock.lib.domain.TransactionID;
import az.rock.lib.domain.outbox.FailOutboxRoot;

import java.util.Optional;

public interface AbstractFailOutboxRepositoryAdapter {
    void persist(FailOutboxRoot root);

    Optional<FailOutboxRoot> findByTransactionId(TransactionID transactionId);
}
