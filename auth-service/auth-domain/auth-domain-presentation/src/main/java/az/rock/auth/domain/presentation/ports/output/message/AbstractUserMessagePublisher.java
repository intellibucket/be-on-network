package az.rock.auth.domain.presentation.ports.output.message;

import az.rock.flyjob.auth.event.UserCreatedEvent;

public interface AbstractUserMessagePublisher {
    void publish(UserCreatedEvent userCreatedEvent);
}
