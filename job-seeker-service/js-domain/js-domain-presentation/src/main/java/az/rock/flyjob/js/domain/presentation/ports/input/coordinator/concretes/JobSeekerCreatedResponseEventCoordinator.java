package az.rock.flyjob.js.domain.presentation.ports.input.coordinator.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.coordinator.abstracts.AbstractJobSeekerCreatedResponseEventCoordinator;
import az.rock.flyjob.js.domain.presentation.ports.output.publisher.AbstractJobSeekerFailResponseMessagePublisher;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobSeekerCreatedResponseEventCoordinator extends AbstractJobSeekerCreatedResponseEventCoordinator {


    @Value(value = "${topic.js.created.name}")
    private String jobSeekerCreatedTopicName;


    protected JobSeekerCreatedResponseEventCoordinator(AbstractJobSeekerFailResponseMessagePublisher jobSeekerFailResponseMessagePublisher) {
        super(jobSeekerFailResponseMessagePublisher);
    }

    @Override
    public void execute(SagaStartedProcess<JobSeekerCreatedEvent> sagaProcess) throws JDomainException {
        log.info("Company created event received: {}", sagaProcess.getEvent().getPayload().toString());
        JobSeekerRegistrationPayload payload = sagaProcess.getEvent().getPayload();
        //this.jsCommandDomainPresentationService.createResume(payload);
    }

    @Override
    protected String getTopic() {
        return this.jobSeekerCreatedTopicName;
    }

    @Override
    protected void onError(AbstractSagaProcess<JobSeekerCreatedEvent> sagaProcess, Throwable throwable) {

    }
}
