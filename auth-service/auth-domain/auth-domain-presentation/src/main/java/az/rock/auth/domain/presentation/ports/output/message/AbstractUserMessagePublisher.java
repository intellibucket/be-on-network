package az.rock.auth.domain.presentation.ports.output.message;

import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.lib.annotation.OutputPort;

@OutputPort
public interface AbstractUserMessagePublisher {
    void publish(UserCreatedEvent userCreatedEvent);
}
