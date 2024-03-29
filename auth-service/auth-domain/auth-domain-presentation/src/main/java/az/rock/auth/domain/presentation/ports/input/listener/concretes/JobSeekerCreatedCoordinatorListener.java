package az.rock.auth.domain.presentation.ports.input.listener.concretes;

import az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts.AbstractJobSeekerCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.input.listener.abstracts.AbstractCoordinatorListener;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import org.springframework.stereotype.Component;

@Component
public class JobSeekerCreatedCoordinatorListener implements AbstractCoordinatorListener {
    private final AbstractJobSeekerCreateEventCoordinator jobSeekerCreateEventCoordinator;

    public JobSeekerCreatedCoordinatorListener(AbstractJobSeekerCreateEventCoordinator jobSeekerCreateEventCoordinator) {
        this.jobSeekerCreateEventCoordinator = jobSeekerCreateEventCoordinator;
    }

    @Override
    public void listenOnSuccess(AbstractSagaProcess<AbstractSuccessDomainEvent<? extends Payload>> message) {
        this.jobSeekerCreateEventCoordinator.successProcess(message);
    }

    @Override
    public void listenOnFail(AbstractSagaProcess<AbstractFailDomainEvent<? extends Payload>> message) {
        this.jobSeekerCreateEventCoordinator.failProcess(message);
    }
}
