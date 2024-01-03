package az.rock.auth.domain.presentation.ports.input.coordinator.starter.concretes;

import az.rock.auth.domain.presentation.ports.input.coordinator.starter.abstracts.AbstractCompanyCreateEventCoordinator;
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
    private String companyCreatedTopicName;


    public CompanyCreateEventCoordinator(AbstractUserMessagePublisher<CompanyCreatedEvent> userMessagePublisher1) {
        super(userMessagePublisher1);
    }

    @Override
    public String getTopic() {
        return this.companyCreatedTopicName;
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
