package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.device.AuthenticationLogEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractAuthenticationLogDataAccessMapper;
import az.rock.flyjob.auth.root.user.device.AuthenticationLogRoot;
import az.rock.lib.domain.id.AuthenticationLogID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AuthenticationLogDataAccessMapper implements AbstractAuthenticationLogDataAccessMapper<AuthenticationLogEntity, AuthenticationLogRoot> {

    @Override
    public Optional<AuthenticationLogRoot> toRoot(AuthenticationLogEntity entity) {
        var optionalAuthenticationLogEntity = Optional.ofNullable(entity);
        if (optionalAuthenticationLogEntity.isEmpty()) return Optional.empty();
        return Optional.of(AuthenticationLogRoot.Builder
                .builder()
                .authenticationLogID(AuthenticationLogID.of(entity.getUuid()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .dataStatus(entity.getRowStatus())
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                .deviceToken(entity.getDeviceToken())
                .build());
    }

    @Override
    public Optional<AuthenticationLogEntity> toEntity(AuthenticationLogRoot root) {
        var optionalAuthenticationLogRoot = Optional.ofNullable(root);
        if (optionalAuthenticationLogRoot.isEmpty()) return Optional.empty();
        return Optional.of(AuthenticationLogEntity.Builder
                .builder()
                .uuid(root.getUUID().getAbsoluteID())
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getRowStatus())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .deviceToken(root.getDeviceToken())
                .build());
    }

    @Override
    public Optional<AuthenticationLogEntity> toNewEntity(AuthenticationLogRoot root) {
        var optionalAuthenticationLogRoot = Optional.ofNullable(root);
        if (optionalAuthenticationLogRoot.isEmpty()) return Optional.empty();
        return Optional.of(AuthenticationLogEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getRowStatus())
                .deviceToken(root.getDeviceToken())
                .build());
    }
}
