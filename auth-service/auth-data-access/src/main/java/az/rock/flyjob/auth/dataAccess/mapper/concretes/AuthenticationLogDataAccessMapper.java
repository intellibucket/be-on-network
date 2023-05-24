package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.AuthenticationLogEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractAuthenticationLogDataAccessMapper;
import az.rock.flyjob.auth.root.AuthenticationLogRoot;
import az.rock.lib.domain.id.AuthenticationLogID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthenticationLogDataAccessMapper implements AbstractAuthenticationLogDataAccessMapper<AuthenticationLogEntity, AuthenticationLogRoot> {

    @Override
    public AuthenticationLogRoot toRoot(AuthenticationLogEntity entity) {
        return AuthenticationLogRoot.Builder
                .builder()
                .authenticationLogID(AuthenticationLogID.of(entity.getUuid()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .dataStatus(entity.getDataStatus())
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                .deviceToken(entity.getDeviceToken())
                .build();
    }

    @Override
    public AuthenticationLogEntity toEntity(AuthenticationLogRoot root) {
        return AuthenticationLogEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .version(root.getVersion())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .deviceToken(root.getDeviceToken())
                .build();
    }

    @Override
    public AuthenticationLogEntity toNewEntity(AuthenticationLogRoot root) {
        return AuthenticationLogEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .deviceToken(root.getDeviceToken())
                .build();
    }
}
