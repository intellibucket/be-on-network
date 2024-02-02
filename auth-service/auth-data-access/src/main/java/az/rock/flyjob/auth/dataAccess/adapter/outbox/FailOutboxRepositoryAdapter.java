package az.rock.flyjob.auth.dataAccess.adapter.outbox;

import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractFailOutboxRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.exception.NoDataFoundGException;
import az.rock.flyjob.auth.dataAccess.mapper.outbox.abstracts.AbstractFailOutboxDataAccessMapper;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.domain.outbox.FailOutboxRoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class FailOutboxRepositoryAdapter implements AbstractFailOutboxRepositoryAdapter {
    private final AbstractFailOutboxDataAccessMapper failOutboxDataAccessMapper;

    public FailOutboxRepositoryAdapter(AbstractFailOutboxDataAccessMapper failOutboxDataAccessMapper) {
        this.failOutboxDataAccessMapper = failOutboxDataAccessMapper;
    }

    @Override
    public void persist(FailOutboxRoot root) {
        var optionalEntity = failOutboxDataAccessMapper.toEntity(root);
        optionalEntity.ifPresentOrElse(entity -> {
            log.info("FailOutboxRoot persisted");
        }, () -> {
            log.error("FailOutboxRoot not persisted");
            throw new NoDataFoundGException();
        });
    }

    @Override
    public Optional<FailOutboxRoot> findByTransactionId(TransactionID transactionId) {
        return Optional.empty();
    }
}
