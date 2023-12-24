package az.rock.auth.domain.presentation.coordinator.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractJobSeekerCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobSeekerCreateEventCoordinator extends AbstractJobSeekerCreateEventCoordinator {
    private final AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher;

    public JobSeekerCreateEventCoordinator(AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher) {
        this.userMessagePublisher = userMessagePublisher;
    }

    @Override
    protected void saveOutBox(AbstractSagaProcess<JobSeekerCreatedEvent> sagaProcess) {

    }

    @Override
    protected void proceed(AbstractSagaProcess<JobSeekerCreatedEvent> sagaProcess) {
        this.userMessagePublisher.publish(sagaProcess);
        log.info("User Message Published to Queue = > {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
    }

    @Override
    protected void onError(AbstractSagaProcess<JobSeekerCreatedEvent> sagaProcess, Exception exception) {
        log.error("System Error = >  occurred while publishing message to user queue", exception);
    }

    @Override
    public <F extends AbstractFailDomainEvent<? extends Payload>> void onFail(AbstractSagaProcess<F> sagaProcess) {
        log.error("Exception = > occurred while publishing message to user queue {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
    }

    @Override
    public <S extends AbstractSuccessDomainEvent<? extends Payload>> void onSuccess(AbstractSagaProcess<S> sagaProcess) {
        log.info("Success = > response from user queue {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
    }


}
