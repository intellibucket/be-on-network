package az.rock.auth.domain.presentation.ports.output.repository.outbox;

import az.rock.lib.coordinator.outbox.ProcessStepRoot;
import az.rock.lib.domain.TransactionID;

import java.util.List;

public interface AbstractProcessStepRepositoryAdapter {
    void persist(ProcessStepRoot root);

    Boolean isExist(TransactionID transactionID, String step);

    Boolean isCompleted(TransactionID transactionID, List<String> step);

    List<ProcessStepRoot> findByTransactionId(TransactionID transactionId);
}
