package az.rock.flyjob.auth.dataAccess.adapter.outbox;

import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractProcessStepRepositoryAdapter;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.domain.outbox.ProcessStepRoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProcessStepRepositoryAdapter implements AbstractProcessStepRepositoryAdapter {

    @Override
    public void persist(ProcessStepRoot root) {

    }

    @Override
    public Boolean isExist(TransactionID transactionID, String step) {
        return null;
    }

    @Override
    public Boolean isCompleted(TransactionID transactionID, List<String> step) {
        return null;
    }

    @Override
    public List<ProcessStepRoot> findByTransactionId(TransactionID transactionId) {
        return null;
    }
}
