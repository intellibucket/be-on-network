package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractAccountPlanMessagePublisher;
import az.rock.flyjob.auth.event.UpgradedAccountPlanEvent;
import com.intellibucket.lib.payload.trx.SagaProcess;
import org.springframework.stereotype.Component;

@Component
public class AccountPlanMessagePublisher implements AbstractAccountPlanMessagePublisher {
    @Override
    public void publish(SagaProcess<UpgradedAccountPlanEvent> sagaProcess) {
    }
}
