package az.rock.auth.domain.presentation.ports.output.publisher;

import az.rock.flyjob.auth.event.UpgradedAccountPlanEvent;
import az.rock.lib.annotation.DomainOutputPort;
import com.intellibucket.lib.payload.publisher.AbstractMessagePublisher;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DomainOutputPort
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractAccountPlanMessagePublisher extends AbstractMessagePublisher<UpgradedAccountPlanEvent> {
}
