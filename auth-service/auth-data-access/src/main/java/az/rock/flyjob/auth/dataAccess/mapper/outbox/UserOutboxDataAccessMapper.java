package az.rock.flyjob.auth.dataAccess.mapper.outbox;

import az.rock.flyjob.auth.dataAccess.entity.outbox.UserOutboxEntity;
import az.rock.flyjob.auth.root.UserOutboxRoot;
import az.rock.lib.domain.OutboxID;
import az.rock.lib.domain.SagaID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserOutboxDataAccessMapper implements AbstractUserOutboxDataAccessMapper{
    @Override
    public Optional<UserOutboxRoot> toRoot(UserOutboxEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()){
            var outboxEntity = optionalEntity.get();
            return Optional.of(
                    UserOutboxRoot.Builder
                            .builder()
                            .outboxID(OutboxID.of(outboxEntity.getUuid()))
                            .sagaId(SagaID.of(outboxEntity.getSagaId()))
                            .version(Version.of(outboxEntity.getVersion()))
                            .createdDate(GDateTime.toZonedDateTime(outboxEntity.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toZonedDateTime(outboxEntity.getLastModifiedDate()))
                            .sagaStatus(outboxEntity.getSagaStatus())
                            .outboxStatus(outboxEntity.getOutboxStatus())
                            .payload(outboxEntity.getPayload())
                            .type(outboxEntity.getType())
                            .processStatus(outboxEntity.getProcessStatus())
                            .build());
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserOutboxEntity> toEntity(UserOutboxRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isPresent()){
            var outboxRoot = optionalRoot.get();
            return Optional.of(
                    UserOutboxEntity.Builder
                            .builder()
                            .uuid(outboxRoot.getRootID().getRootID())
                            .sagaId(outboxRoot.getSagaId().getRootID())
                            .version(outboxRoot.getVersion().value())
                            .createdDate(GDateTime.toTimestamp(outboxRoot.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toTimestamp(outboxRoot.getLastModifiedDate()))
                            .sagaStatus(outboxRoot.getSagaStatus())
                            .outboxStatus(outboxRoot.getOutboxStatus())
                            .payload(outboxRoot.getPayload())
                            .type(outboxRoot.getType())
                            .processStatus(outboxRoot.getProcessStatus())
                            .build());
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserOutboxEntity> toNewEntity(UserOutboxRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isPresent()){
            var outboxRoot = optionalRoot.get();
            return Optional.of(
                    UserOutboxEntity.Builder
                            .builder()
                            .uuid(outboxRoot.getRootID().getRootID())
                            .sagaId(outboxRoot.getSagaId().getRootID())
                            .version(outboxRoot.getVersion().value())
                            .createdDate(GDateTime.toTimestamp(outboxRoot.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toTimestamp(outboxRoot.getLastModifiedDate()))
                            .sagaStatus(outboxRoot.getSagaStatus())
                            .outboxStatus(outboxRoot.getOutboxStatus())
                            .payload(outboxRoot.getPayload())
                            .type(outboxRoot.getType())
                            .processStatus(outboxRoot.getProcessStatus())
                            .build());
        }
        return Optional.empty();
    }
}
