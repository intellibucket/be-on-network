package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserOutboxDomainMapper;
import az.rock.flyjob.auth.model.root.UserOutboxRoot;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.SagaID;
import az.rock.lib.valueObject.OutboxStatus;
import az.rock.lib.valueObject.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserOutboxDomainMapper implements AbstractUserOutboxDomainMapper {
    @Override
    public UserOutboxRoot mapToStartedOutbox(AbstractDomainEvent<UserRoot> event) {
        var objectMapper = new ObjectMapper();
        var root = event.getPayload();

        return UserOutboxRoot.Builder
                .builder()
                .outboxID(OutboxID.of(UUID.randomUUID()))
                .sagaId(SagaID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .outboxStatus(OutboxStatus.STARTED)
                .processStatus(root.getProcessStatus())
                .build();
    }
}
