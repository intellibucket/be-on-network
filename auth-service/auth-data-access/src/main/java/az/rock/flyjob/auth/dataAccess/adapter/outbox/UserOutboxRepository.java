package az.rock.flyjob.auth.dataAccess.adapter.outbox;

import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractUserOutboxRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.outbox.AbstractUserOutboxDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.outbox.UserOutboxJPARepository;
import az.rock.flyjob.auth.model.root.UserOutboxRoot;
import az.rock.lib.domain.SagaID;

//@Component
public class UserOutboxRepository implements AbstractUserOutboxRepositoryAdapter {
    private final AbstractUserOutboxDataAccessMapper mapper;
    private final UserOutboxJPARepository repository;

    public UserOutboxRepository(AbstractUserOutboxDataAccessMapper mapper, UserOutboxJPARepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public void save(UserOutboxRoot outbox) {
        var entity = mapper.toNewEntity(outbox);
        //entity.ifPresent(repository::save);
    }

    @Override
    public void success(SagaID sagaId) {
        var entity = repository.findBySagaId(sagaId.getRootID());

    }

    @Override
    public void fail(SagaID sagaId) {
        var entity = repository.findBySagaId(sagaId.getRootID());

    }

    @Override
    public void processing(SagaID sagaId) {
        var entity = repository.findBySagaId(sagaId.getRootID());

    }

    @Override
    public void compensating(SagaID sagaId) {
        var entity = repository.findBySagaId(sagaId.getRootID());

    }

    @Override
    public void compensated(SagaID sagaId) {
        var entity = repository.findBySagaId(sagaId.getRootID());

    }
}
