package az.rock.flyjob.auth.messaging;

import az.rock.auth.domain.presentation.ports.output.message.AbstractAccountPlanMessagePublisher;
import az.rock.flyjob.auth.event.UpgradedAccountPlanEvent;
import az.rock.lib.valueObject.SagaRoot;
import org.springframework.stereotype.Component;

@Component
public class AccountPlanMessagePublisher implements AbstractAccountPlanMessagePublisher {
    @Override
    public void publish(SagaRoot<UpgradedAccountPlanEvent> sagaRoot) {

    }
}
