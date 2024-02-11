package az.rock.flyjob.auth.dataAccess.adapter.outbox;

import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractFailOutboxRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.exception.NoDataFoundDataAccessException;
import az.rock.flyjob.auth.dataAccess.mapper.outbox.abstracts.AbstractFailOutboxDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.outbox.FailOutboxJPARepository;
import az.rock.lib.coordinator.outbox.FailOutboxRoot;
import az.rock.lib.domain.TransactionID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class FailOutboxRepositoryAdapter implements AbstractFailOutboxRepositoryAdapter {
    private final FailOutboxJPARepository failOutboxJPARepository;
    private final AbstractFailOutboxDataAccessMapper failOutboxDataAccessMapper;

    public FailOutboxRepositoryAdapter(FailOutboxJPARepository failOutboxJPARepository,
                                       AbstractFailOutboxDataAccessMapper failOutboxDataAccessMapper) {
        this.failOutboxJPARepository = failOutboxJPARepository;
        this.failOutboxDataAccessMapper = failOutboxDataAccessMapper;
    }

    @Override
    public void persist(FailOutboxRoot root) {
        var optionalEntity = failOutboxDataAccessMapper.toEntity(root);
        optionalEntity.ifPresentOrElse(entity -> {
            log.info("FailOutboxRoot persisted");
            failOutboxJPARepository.save(entity);
        }, () -> {
            log.error("FailOutboxRoot not persisted");
            throw new NoDataFoundDataAccessException();
        });
    }

    @Override
    public List<FailOutboxRoot> findByTransactionId(TransactionID transactionId) {
        return failOutboxJPARepository.findByTransactionId(transactionId.getAbsoluteID())
                .stream()
                .map(failOutboxDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
