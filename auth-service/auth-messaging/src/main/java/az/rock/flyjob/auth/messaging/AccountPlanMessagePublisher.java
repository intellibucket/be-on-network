package az.rock.flyjob.auth.messaging;

import az.rock.auth.domain.presentation.ports.output.message.AbstractAccountPlanMessagePublisher;
import az.rock.flyjob.auth.event.UpgradedAccountPlanEvent;
import az.rock.lib.valueObject.SagaRoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountPlanMessagePublisher implements AbstractAccountPlanMessagePublisher {
    @Override
    public void publish(SagaRoot<UpgradedAccountPlanEvent> sagaRoot) {
        log.info("Account Plan Message Publisher");
    }
}
