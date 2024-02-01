package az.rock.flyjob.js.domain.presentation.ports.input.coordinator.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.coordinator.abstracts.AbstractJobSeekerCreatedResponseEventCoordinator;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractResumeCommandDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.publisher.AbstractJobSeekerResponseMessagePublisher;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.outbox.JobSeekerRegistrationSteps;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Component
@Slf4j
public class JobSeekerCreatedResponseEventCoordinator extends AbstractJobSeekerCreatedResponseEventCoordinator {


    @Value(value = "${topic.js.created.start}")
    private String jobSeekerStartCreatedTopicName;

    @Value(value = "${topic.js.created.success}")
    private String jobSeekerSuccessCreatedTopicName;

    @Value(value = "${topic.js.created.fail}")
    private String jobSeekerFailCreatedTopicName;

    private final AbstractResumeCommandDomainPresentationService jsCommandDomainPresentationService;


    protected JobSeekerCreatedResponseEventCoordinator(AbstractJobSeekerResponseMessagePublisher jobSeekerFailResponseMessagePublisher,
                                                       AbstractResumeCommandDomainPresentationService jsCommandDomainPresentationService) {
        super(jobSeekerFailResponseMessagePublisher);
        this.jsCommandDomainPresentationService = jsCommandDomainPresentationService;
    }

    @Override
    public AbstractSuccessDomainEvent<?> execute(SagaStartedProcess<JobSeekerCreatedEvent> sagaProcess) throws JDomainException {
        log.info("Company created event received: {}", sagaProcess.getEvent().getPayload().toString());
        JobSeekerRegistrationPayload payload = sagaProcess.getEvent().getPayload();
        return this.jsCommandDomainPresentationService.create(payload);
    }

    @Override
    protected void onError(AbstractSagaProcess<JobSeekerCreatedEvent> sagaProcess, Throwable throwable) {

    }

    @Override
    protected String getStartTopic() {
        return this.jobSeekerStartCreatedTopicName;
    }

    @Override
    protected String getSuccessTopic() {
        return this.jobSeekerSuccessCreatedTopicName;
    }

    @Override
    protected String getFailTopic() {
        return this.jobSeekerFailCreatedTopicName;
    }

    @Override
    protected Enum<?> getStep() {
        return JobSeekerRegistrationSteps.CREATING_JOB_SEEKER_PROFILE;
    }

    @Override
    protected BiConsumer<String, AbstractSagaProcess<?>> endAction() {
        return this.getJobSeekerFailResponseMessagePublisher()::publish;
    }

}
