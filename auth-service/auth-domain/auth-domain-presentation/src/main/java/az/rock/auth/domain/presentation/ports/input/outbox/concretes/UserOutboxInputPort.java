package az.rock.auth.domain.presentation.ports.input.outbox.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserOutboxDomainMapper;
import az.rock.auth.domain.presentation.ports.input.outbox.abstracts.AbstractUserOutboxInputPort;
import az.rock.auth.domain.presentation.ports.output.repository.outbox.AbstractUserOutboxRepositoryAdapter;
import az.rock.flyjob.auth.root.UserOutboxRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.SagaID;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.SagaRoot;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class UserOutboxInputPort implements AbstractUserOutboxInputPort {
    private final AbstractUserOutboxRepositoryAdapter repositoryAdapter;
    private final AbstractUserOutboxDomainMapper domainMapper;

    public UserOutboxInputPort(AbstractUserOutboxRepositoryAdapter repositoryAdapter,
                               AbstractUserOutboxDomainMapper domainMapper) {
        this.repositoryAdapter = repositoryAdapter;
        this.domainMapper = domainMapper;
    }

    @Override
    public SagaRoot<AbstractDomainEvent<UserRoot>> save(AbstractDomainEvent<UserRoot> event) {
        var userOutboxRoot = this.domainMapper.mapToStartedOutbox(event);
        this.repositoryAdapter.save(userOutboxRoot);
        return SagaRoot.of(userOutboxRoot.getSagaId(),userOutboxRoot.getSagaStatus(), GDateTime.UTC.now(),event);
    }

    @Override
    public void success(SagaID sagaId) {
        this.repositoryAdapter.success(sagaId);
    }

    @Override
    public void fail(SagaID sagaId) {
        this.repositoryAdapter.fail(sagaId);
    }

    @Override
    public void processing(SagaID sagaId) {
        this.repositoryAdapter.processing(sagaId);
    }

    @Override
    public void compensating(SagaID sagaId) {
        this.repositoryAdapter.compensating(sagaId);
    }

    @Override
    public void compensated(SagaID sagaId) {
        this.repositoryAdapter.compensated(sagaId);
    }
}
