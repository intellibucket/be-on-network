package az.rock.flyjob.js.domain.presentation.ports.output.publisher;

import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.trx.SagaFailedProcess;

public interface AbstractJobSeekerFailResponseMessagePublisher {
    void publish(String failTopic, SagaFailedProcess<AbstractFailDomainEvent<?>> failedSagaProcess);
}
