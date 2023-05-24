package az.rock.flyjob.auth.messaging;

import az.rock.auth.domain.presentation.ports.output.message.AbstractUserMessagePublisher;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserMessagePublisher implements AbstractUserMessagePublisher {
    @Override
    public void publish(UserCreatedEvent userCreatedEvent) {

    }
}
