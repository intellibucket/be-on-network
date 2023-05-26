package az.rock.auth.domain.presentation.ports.input.handler.abstracts;

import az.rock.flyjob.auth.event.DetailCreatedEvent;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.flyjob.auth.root.UserRoot;

public interface AbstractDetailCreateCommandHandler {
    DetailCreatedEvent handle(UserRoot userRoot);
}
