package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserOutboxDomainMapper;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.domain.outbox.ProcessOutboxRoot;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import org.springframework.stereotype.Component;

@Component
public class UserOutboxDomainMapper implements AbstractUserOutboxDomainMapper {
    @Override
    public ProcessOutboxRoot mapToStartedOutbox(AbstractDomainEvent<UserRoot> event) {
        var objectMapper = new ObjectMapper();
        var root = event.getPayload();

        return null;
    }
}
