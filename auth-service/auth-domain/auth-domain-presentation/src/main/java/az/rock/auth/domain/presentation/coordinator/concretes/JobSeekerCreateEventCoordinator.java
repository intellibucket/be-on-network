package az.rock.auth.domain.presentation.coordinator.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractJobSeekerCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.Saga;
import org.springframework.stereotype.Component;

@Component
public class JobSeekerCreateEventCoordinator extends AbstractJobSeekerCreateEventCoordinator {
    private final AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher;

    public JobSeekerCreateEventCoordinator(AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher) {
        this.userMessagePublisher = userMessagePublisher;
    }

    @Override
    protected void proceed(Saga<JobSeekerCreatedEvent> saga) {
        this.userMessagePublisher.publish(saga);
    }

    @Override
    protected void onError(Exception exception, Saga<JobSeekerCreatedEvent> saga) {
        System.err.println(exception.getMessage());
    }

    @Override
    public <F extends AbstractFailDomainEvent<? extends Payload>> void onFail(Saga<F> saga) {

    }

    @Override
    public <S extends AbstractSuccessDomainEvent<? extends Payload>> void onSuccess(Saga<S> saga) {

    }


}
