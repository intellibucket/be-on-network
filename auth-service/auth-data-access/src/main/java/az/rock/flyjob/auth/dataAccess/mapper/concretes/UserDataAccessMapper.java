package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserDataAccessMapper;
import az.rock.flyjob.auth.root.UserRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDataAccessMapper implements AbstractUserDataAccessMapper<UserEntity, UserRoot> {

    @Override
    public UserRoot toRoot(UserEntity entity) {
        return UserRoot.Builder
                .builder()
                .id(UserID.of(entity.getUuid()))
                .createdDate(GDateTime.of(entity.getCreatedDate()))
                .modificationDate(GDateTime.of(entity.getLastModifiedDate()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .dataStatus(entity.getDataStatus())
                .key(entity.getKey())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .username(entity.getUsername())
                .timezone(entity.getTimezone())
                .build();
    }

    @Override
    public UserEntity toEntity(UserRoot root) {
        return UserEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .version(root.getVersion())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .key(root.getKey())
                .firstName(root.getFirstName())
                .lastName(root.getLastName())
                .username(root.getUsername())
                .timezone(root.getTimezone())
                .build();
    }

    @Override
    public UserEntity toNewEntity(UserRoot root) {
        return UserEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .key(root.getKey())
                .firstName(root.getFirstName())
                .lastName(root.getLastName())
                .username(root.getUsername())
                .timezone(root.getTimezone())
                .build();
    }

}

