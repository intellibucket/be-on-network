package az.rock.auth.domain.presentation.ports.input.outbox.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserOutboxDomainMapper;
import az.rock.auth.domain.presentation.ports.input.outbox.abstracts.AbstractUserOutboxInputPort;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.domain.TransactionID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.SagaRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import org.springframework.stereotype.Service;

@Service
public class UserOutboxInputPort implements AbstractUserOutboxInputPort {
    //private final AbstractUserOutboxRepositoryAdapter repositoryAdapter;
    private final AbstractUserOutboxDomainMapper domainMapper;

    public UserOutboxInputPort(//AbstractUserOutboxRepositoryAdapter repositoryAdapter,
                               AbstractUserOutboxDomainMapper domainMapper) {
        //this.repositoryAdapter = repositoryAdapter;
        this.domainMapper = domainMapper;
    }

    @Override
    public SagaRoot<AbstractDomainEvent<UserRoot>> save(AbstractDomainEvent<UserRoot> event) {
        var userOutboxRoot = this.domainMapper.mapToStartedOutbox(event);
        //this.repositoryAdapter.save(userOutboxRoot);
        return SagaRoot.of(userOutboxRoot.getTransactionId(), null, GDateTime.UTC.now(), event);
    }

    @Override
    public void success(TransactionID transactionId) {
        //this.repositoryAdapter.success(sagaId);
    }

    @Override
    public void fail(TransactionID transactionId) {
        //this.repositoryAdapter.fail(sagaId);
    }

    @Override
    public void processing(TransactionID transactionId) {
        //this.repositoryAdapter.processing(sagaId);
    }

    @Override
    public void compensating(TransactionID transactionId) {
        // this.repositoryAdapter.compensating(sagaId);
    }

    @Override
    public void compensated(TransactionID transactionId) {
        //this.repositoryAdapter.compensated(sagaId);
    }
}
