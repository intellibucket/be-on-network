package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserOutboxDomainMapper;
import az.rock.flyjob.auth.root.UserOutboxRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.SagaID;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.valueObject.OutboxStatus;
import az.rock.lib.valueObject.Version;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import az.rock.lib.event.payload.UserCreatedEventPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserOutboxDomainMapper implements AbstractUserOutboxDomainMapper {
    @Override
    public UserOutboxRoot mapToStartedOutbox(AbstractDomainEvent<UserRoot> event) {
        var objectMapper = new ObjectMapper();
        var root = event.getPayload();
        var payload =
                UserCreatedEventPayload.of(root.getRootID().getAbsoluteID(),root.getUserType());
        String payloadString;
        try {
            payloadString = objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return UserOutboxRoot.Builder
                .builder()
                .outboxID(OutboxID.of(UUID.randomUUID()))
                .sagaId(SagaID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .outboxStatus(OutboxStatus.STARTED)
                .payload(payloadString)
                .processStatus(root.getProcessStatus())
                .build();
    }
}
