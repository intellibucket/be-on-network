package az.rock.auth.domain.presentation.coordinator.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractCompanyCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import com.intellibucket.lib.payload.event.abstracts.AbstractFailDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.payload.Payload;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompanyCreateEventCoordinator extends AbstractCompanyCreateEventCoordinator {

    @Value(value = "${topic.cmp.created.name}")
    private String cmpTopic;

    private final AbstractUserMessagePublisher<CompanyCreatedEvent> userMessagePublisher;

    public CompanyCreateEventCoordinator(AbstractUserMessagePublisher<CompanyCreatedEvent> userMessagePublisher) {
        this.userMessagePublisher = userMessagePublisher;
    }

    @Override
    protected void proceed(AbstractSagaProcess<CompanyCreatedEvent> sagaProcess) {
        this.userMessagePublisher.publish(sagaProcess, cmpTopic);
        log.info("User Message Published to Queue = > {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
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
