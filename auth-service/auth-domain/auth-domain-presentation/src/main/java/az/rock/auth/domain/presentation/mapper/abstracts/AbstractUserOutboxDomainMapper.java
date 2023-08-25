package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.UserOutboxRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;

public interface AbstractUserOutboxDomainMapper {
    UserOutboxRoot mapToStartedOutbox(AbstractDomainEvent<UserRoot> event);
}
