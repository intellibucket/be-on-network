package az.rock.auth.domain.presentation.ports.input.outbox.abstracts;

import az.rock.flyjob.auth.root.UserOutboxRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.event.AbstractDomainEvent;

public interface AbstractUserOutboxInputPort extends AbstractOutboxInputPort<AbstractDomainEvent<UserRoot>, UserOutboxRoot> {
}
