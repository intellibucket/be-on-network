package az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.coordinator.AbstractEventCoordinator;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Slf4j
public abstract class AbstractUserCreateEventCoordinator<E extends AbstractDomainEvent> extends AbstractEventCoordinator<E> {
    private final AbstractUserMessagePublisher<E> userMessagePublisher;

    protected AbstractUserCreateEventCoordinator(AbstractUserMessagePublisher<E> userMessagePublisher) {
        this.userMessagePublisher = userMessagePublisher;
    }

    public abstract String getTopic();

    @Override
    protected void proceed(AbstractSagaProcess<E> sagaProcess) {
        this.userMessagePublisher.publish(sagaProcess, this.getTopic());
        log.info("User Message Published to Queue = > {}", sagaProcess.getTransactionId(), sagaProcess.getStep(), sagaProcess.getProcessStatus());
    }
}
