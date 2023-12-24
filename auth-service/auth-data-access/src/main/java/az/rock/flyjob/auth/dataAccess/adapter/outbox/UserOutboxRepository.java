package az.rock.flyjob.auth.dataAccess.adapter.outbox;

import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractUserOutboxRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.outbox.AbstractUserOutboxDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.outbox.UserOutboxJPARepository;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.domain.outbox.ProcessOutboxRoot;

//@Component
public class UserOutboxRepository implements AbstractUserOutboxRepositoryAdapter {
    private final AbstractUserOutboxDataAccessMapper mapper;
    private final UserOutboxJPARepository repository;

    public UserOutboxRepository(AbstractUserOutboxDataAccessMapper mapper, UserOutboxJPARepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public void save(ProcessOutboxRoot outbox) {
        var entity = mapper.toNewEntity(outbox);
        //entity.ifPresent(repository::save);
    }

    @Override
    public void success(TransactionID transactionId) {
        var entity = repository.findBySagaId(transactionId.getRootID());

    }

    @Override
    public void fail(TransactionID transactionId) {
        var entity = repository.findBySagaId(transactionId.getRootID());

    }

    @Override
    public void processing(TransactionID transactionId) {
        var entity = repository.findBySagaId(transactionId.getRootID());

    }

    @Override
    public void compensating(TransactionID transactionId) {
        var entity = repository.findBySagaId(transactionId.getRootID());

    }

    @Override
    public void compensated(TransactionID transactionId) {
        var entity = repository.findBySagaId(transactionId.getRootID());

    }
}
