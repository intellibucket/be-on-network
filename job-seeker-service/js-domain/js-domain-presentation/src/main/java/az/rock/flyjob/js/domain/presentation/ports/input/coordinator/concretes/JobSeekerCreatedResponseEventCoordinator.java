package az.rock.flyjob.js.domain.presentation.ports.input.coordinator.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.coordinator.abstracts.AbstractJobSeekerCreatedResponseEventCoordinator;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractResumeCommandDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.publisher.AbstractJobSeekerFailResponseMessagePublisher;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
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


    @Value(value = "${topic.js.created.name}")
    private String jobSeekerCreatedTopicName;

    private final AbstractResumeCommandDomainPresentationService jsCommandDomainPresentationService;

    protected JobSeekerCreatedResponseEventCoordinator(AbstractJobSeekerFailResponseMessagePublisher jobSeekerFailResponseMessagePublisher,
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
    protected String getTopic() {
        return this.jobSeekerCreatedTopicName;
    }

    @Override
    protected Enum<?> getStep() {
        return null;
    }

    @Override
    protected BiConsumer<String, AbstractSagaProcess<?>> endAction() {
        return null;
    }

    @Override
    protected void onError(AbstractSagaProcess<JobSeekerCreatedEvent> sagaProcess, Throwable throwable) {

    }
}
