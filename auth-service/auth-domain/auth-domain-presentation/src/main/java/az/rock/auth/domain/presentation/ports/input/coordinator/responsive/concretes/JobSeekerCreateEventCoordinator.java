package az.rock.auth.domain.presentation.ports.input.coordinator.responsive.concretes;

import az.rock.auth.domain.presentation.ports.input.coordinator.responsive.abstracts.AbstractJobSeekerCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobSeekerCreateEventCoordinator extends AbstractJobSeekerCreateEventCoordinator {

    @Value(value = "${topic.js.created.name}")
    private String jobSeekerCreatedTopicName;


    public JobSeekerCreateEventCoordinator(AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher) {
        super(userMessagePublisher);
    }

    @Override
    public String getTopic() {
        return this.jobSeekerCreatedTopicName;
    }

    @Override
    protected void saveOutBox(AbstractSagaProcess<JobSeekerCreatedEvent> sagaProcess) {
        log.info("Save OutBox = > {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());

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
