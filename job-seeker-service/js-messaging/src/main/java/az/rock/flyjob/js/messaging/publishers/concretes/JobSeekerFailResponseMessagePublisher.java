package az.rock.flyjob.js.messaging.publishers.concretes;

import az.rock.flyjob.js.domain.presentation.ports.output.publisher.AbstractJobSeekerFailResponseMessagePublisher;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.trx.SagaFailedProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobSeekerFailResponseMessagePublisher implements AbstractJobSeekerFailResponseMessagePublisher {
    @Override
    public void publish(String failTopic, SagaFailedProcess<AbstractFailDomainEvent<?>> failedSagaProcess) {
        log.info("Job seeker fail response event published: {}", failedSagaProcess.toString());
    }
}
