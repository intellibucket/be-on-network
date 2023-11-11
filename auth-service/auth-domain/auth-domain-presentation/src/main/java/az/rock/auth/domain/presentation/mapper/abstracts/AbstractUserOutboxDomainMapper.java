package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.model.root.UserOutboxRoot;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;

public interface AbstractUserOutboxDomainMapper {
    UserOutboxRoot mapToStartedOutbox(AbstractDomainEvent<UserRoot> event);
}
