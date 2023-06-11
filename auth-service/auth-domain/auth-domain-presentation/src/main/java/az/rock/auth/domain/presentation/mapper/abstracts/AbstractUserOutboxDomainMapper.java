package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.UserOutboxRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.event.AbstractDomainEvent;

public interface AbstractUserOutboxDomainMapper {
    UserOutboxRoot mapToStartedOutbox(AbstractDomainEvent<UserRoot> event);
}
