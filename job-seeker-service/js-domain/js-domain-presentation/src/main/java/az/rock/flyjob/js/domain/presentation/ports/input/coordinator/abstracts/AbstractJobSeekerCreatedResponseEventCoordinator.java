package az.rock.flyjob.js.domain.presentation.ports.input.coordinator.abstracts;

import az.rock.flyjob.js.domain.presentation.ports.output.publisher.AbstractJobSeekerResponseMessagePublisher;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.coordinator.AbstractEventResponseCoordinator;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.outbox.CompanyRegistrationSteps;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaFailedProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractJobSeekerCreatedResponseEventCoordinator extends AbstractEventResponseCoordinator<JobSeekerRegistrationPayload, JobSeekerCreatedEvent> {
    private final AbstractJobSeekerResponseMessagePublisher jobSeekerFailResponseMessagePublisher;

    protected AbstractJobSeekerCreatedResponseEventCoordinator(AbstractJobSeekerResponseMessagePublisher jobSeekerFailResponseMessagePublisher) {
        this.jobSeekerFailResponseMessagePublisher = jobSeekerFailResponseMessagePublisher;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public abstract AbstractSuccessDomainEvent<?> execute(SagaStartedProcess<JobSeekerCreatedEvent> sagaProcess) throws JDomainException;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void onFail(AbstractSagaProcess<JobSeekerCreatedEvent> sagaProcess, JDomainException exception) {
        var failedSagaProcess = SagaFailedProcess.onFail(sagaProcess, CompanyRegistrationSteps.CREATING_COMPANY_PROFILE);
        this.jobSeekerFailResponseMessagePublisher.publish(this.getFailTopic(), failedSagaProcess);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected abstract void onError(AbstractSagaProcess<JobSeekerCreatedEvent> sagaProcess, Throwable throwable);

    public AbstractJobSeekerResponseMessagePublisher getJobSeekerFailResponseMessagePublisher() {
        return jobSeekerFailResponseMessagePublisher;
    }
}
