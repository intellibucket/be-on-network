package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.model.entity.RoleEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractRoleDataAccessMapper;
import az.rock.flyjob.auth.root.RoleRoot;
import az.rock.lib.domain.id.auth.*;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class RoleDataAccessMapper  implements AbstractRoleDataAccessMapper<RoleEntity, RoleRoot> {
    @Override
    public Optional<RoleRoot> toRoot(RoleEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(RoleRoot.Builder
                .builder()
                .roleID(RoleID.of(entity.getUuid()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .dataStatus(entity.getRowStatus())
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                .name(entity.getName())
                .description(entity.getDescription())
                .build());
    }

    @Override
    public Optional<RoleEntity> toEntity(RoleRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(RoleEntity.Builder
                .builder()
                .uuid(root.getRootID().getAbsoluteID())
                .version(root.getVersionValue())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getRowStatus())
                .name(root.getName())
                .description(root.getDescription())
                .build());
    }

    @Override
    public Optional<RoleEntity> toNewEntity(RoleRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(RoleEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getRowStatus())
                .name(root.getName())
                .description(root.getDescription())
                .build());
    }
}
