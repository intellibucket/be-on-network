package az.rock.auth.domain.presentation.ports.input.listener.concretes;

import az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts.AbstractCompanyCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.input.listener.abstracts.AbstractCoordinatorListener;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import org.springframework.stereotype.Component;

@Component
public class CompanyCreatedCoordinatorListener implements AbstractCoordinatorListener {
    private final AbstractCompanyCreateEventCoordinator companyCreateEventCoordinator;

    public CompanyCreatedCoordinatorListener(AbstractCompanyCreateEventCoordinator companyCreateEventCoordinator) {
        this.companyCreateEventCoordinator = companyCreateEventCoordinator;
    }

    @Override
    public void listenOnSuccess(AbstractSagaProcess<AbstractSuccessDomainEvent<? extends Payload>> message) {
        this.companyCreateEventCoordinator.successProcess(message);
    }

    @Override
    public void listenOnFail(AbstractSagaProcess<AbstractFailDomainEvent<? extends Payload>> message) {
        this.companyCreateEventCoordinator.failProcess(message);
    }
}
