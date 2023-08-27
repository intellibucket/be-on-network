package az.rock.flyjob.auth.messaging.publisher;

import az.rock.auth.domain.presentation.ports.output.publisher.AbstractAccountPlanMessagePublisher;
import az.rock.flyjob.auth.event.UpgradedAccountPlanEvent;
import com.intellibukcet.lib.payload.trx.Saga;
import az.rock.lib.valueObject.SagaRoot;
import com.intellibukcet.lib.payload.trx.Saga;
import org.springframework.stereotype.Component;

@Component
public class AccountPlanMessagePublisher implements AbstractAccountPlanMessagePublisher {
    @Override
    public void publish(Saga<UpgradedAccountPlanEvent> saga) {
    }
}
