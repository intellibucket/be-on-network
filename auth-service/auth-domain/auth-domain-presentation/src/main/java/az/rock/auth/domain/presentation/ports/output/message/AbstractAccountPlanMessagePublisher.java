package az.rock.auth.domain.presentation.ports.output.message;

import az.rock.flyjob.auth.event.UpgradedAccountPlanEvent;
import az.rock.lib.annotation.OutputPort;
import az.rock.lib.event.publisher.AbstractMessagePublisher;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@OutputPort
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractAccountPlanMessagePublisher extends AbstractMessagePublisher<UpgradedAccountPlanEvent> {
}
