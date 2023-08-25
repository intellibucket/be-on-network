package az.rock.auth.domain.presentation.ports.output.publisher;

import az.rock.lib.annotation.DomainOutputPort;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.publisher.AbstractMessagePublisher;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DomainOutputPort
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractUserMessagePublisher<S extends AbstractDomainEvent> extends AbstractMessagePublisher<S> {


}
