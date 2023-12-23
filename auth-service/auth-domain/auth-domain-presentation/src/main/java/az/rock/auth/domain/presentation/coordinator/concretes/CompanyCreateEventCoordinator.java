package az.rock.auth.domain.presentation.coordinator.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractCompanyCreateEventCoordinator;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.SagaProcess;
import org.springframework.stereotype.Component;

@Component
public class CompanyCreateEventCoordinator extends AbstractCompanyCreateEventCoordinator {

    @Override
    protected void proceed(SagaProcess<CompanyCreatedEvent> sagaProcess) {

    }

    @Override
    public <F extends AbstractFailDomainEvent<? extends Payload>> void onFail(SagaProcess<F> sagaProcess) {

    }

    @Override
    public <S extends AbstractSuccessDomainEvent<? extends Payload>> void onSuccess(SagaProcess<S> sagaProcess) {

    }
}
