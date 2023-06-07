package az.rock.auth.domain.presentation.ports.output.message;

import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.lib.annotation.OutputPort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@OutputPort
public interface AbstractUserMessagePublisher {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void publish(UserCreatedEvent userCreatedEvent);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void publish(CompanyCreatedEvent companyCreatedEvent);
}
