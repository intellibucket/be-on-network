package az.rock.auth.domain.presentation.ports.output.repository.outbox;

import az.rock.lib.domain.TransactionID;
import az.rock.lib.domain.outbox.ProcessOutboxRoot;

public interface AbstractProcessOutboxRepositoryAdapter {
    void save(ProcessOutboxRoot outbox);

    void complete(TransactionID transactionId, String step);

    void fail(TransactionID transactionId, String step);

}
