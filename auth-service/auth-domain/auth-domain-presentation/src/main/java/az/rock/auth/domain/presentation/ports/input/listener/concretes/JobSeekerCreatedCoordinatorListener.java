package az.rock.auth.domain.presentation.ports.input.listener.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractJobSeekerCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.input.listener.abstracts.AbstractCoordinatorListener;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.SagaProcess;
import org.springframework.stereotype.Component;

@Component
public class JobSeekerCreatedCoordinatorListener implements AbstractCoordinatorListener {
    private final AbstractJobSeekerCreateEventCoordinator jobSeekerCreateEventCoordinator;

    public JobSeekerCreatedCoordinatorListener(AbstractJobSeekerCreateEventCoordinator jobSeekerCreateEventCoordinator) {
        this.jobSeekerCreateEventCoordinator = jobSeekerCreateEventCoordinator;
    }

    @Override
    public void listenOnSuccess(SagaProcess<AbstractSuccessDomainEvent<? extends Payload>> message) {
        this.jobSeekerCreateEventCoordinator.onSuccess(message);
    }

    @Override
    public void listenOnFail(SagaProcess<AbstractFailDomainEvent<? extends Payload>> message) {
        this.jobSeekerCreateEventCoordinator.onFail(message);
    }
}
