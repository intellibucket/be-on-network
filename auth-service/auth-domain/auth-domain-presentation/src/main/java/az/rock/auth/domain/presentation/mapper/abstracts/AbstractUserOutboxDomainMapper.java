package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.coordinator.outbox.ProcessOutboxRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;

public interface AbstractUserOutboxDomainMapper {
    ProcessOutboxRoot mapToStartedOutbox(AbstractDomainEvent<UserRoot> event);
}
