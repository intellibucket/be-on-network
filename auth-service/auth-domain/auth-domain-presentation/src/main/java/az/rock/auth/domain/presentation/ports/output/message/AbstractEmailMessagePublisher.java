package az.rock.auth.domain.presentation.ports.output.message;

import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.annotation.OutputPort;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.publisher.AbstractMessagePublisher;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@OutputPort
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractEmailMessagePublisher extends AbstractMessagePublisher<AbstractDomainEvent<EmailRoot>> {
}
