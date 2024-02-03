package az.rock.flyjob.auth.dataAccess.adapter.outbox;

import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractProcessOutboxRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.outbox.abstracts.AbstractProcessOutboxDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.outbox.ProcessOutboxJPARepository;
import az.rock.lib.coordinator.outbox.ProcessOutboxRoot;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.jexception.JRuntimeException;
import com.intellibucket.lib.payload.trx.TrxProcessStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProcessOutboxRepositoryAdapter implements AbstractProcessOutboxRepositoryAdapter {
    private final AbstractProcessOutboxDataAccessMapper mapper;
    private final ProcessOutboxJPARepository repository;

    public ProcessOutboxRepositoryAdapter(AbstractProcessOutboxDataAccessMapper mapper, ProcessOutboxJPARepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public void persist(ProcessOutboxRoot outbox) {
        var entity = mapper.toEntity(outbox);
        entity.ifPresentOrElse(repository::save, () -> {
            throw new JRuntimeException("Outbox entity not found");
        });
    }

    @Override
    public void complete(TransactionID transactionId, String step) {
        var entity = repository.findByTransactionId(transactionId.getRootID());
        entity.ifPresentOrElse(outbox -> {
            if (outbox.isOnStarted() || outbox.isOnRestarted()) {
                outbox.setStep(step);
                outbox.setTrxStatus(TrxProcessStatus.COMPLETED);
                repository.save(outbox);
            } else {
                log.warn("Process transaction alraedy on {}", outbox.getTrxStatus());
            }
        }, () -> {
            throw new JRuntimeException("Outbox entity not found");
        });
    }

    @Override
    public void fail(TransactionID transactionId, String step) {
        var entity = repository.findByTransactionId(transactionId.getRootID());
        entity.ifPresentOrElse(outbox -> {
            outbox.setStep(step);
            outbox.setTrxStatus(TrxProcessStatus.FAILED);
            repository.save(outbox);
        }, () -> {
            throw new JRuntimeException("Outbox entity not found");
        });
    }

}
