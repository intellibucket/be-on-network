package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.RoleEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractRoleDataAccessMapper;
import az.rock.flyjob.auth.root.RoleRoot;
import az.rock.lib.domain.id.RoleID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RoleDataAccessMapper  implements AbstractRoleDataAccessMapper<RoleEntity, RoleRoot> {
    @Override
    public RoleRoot toRoot(RoleEntity entity) {
        return RoleRoot.Builder
                .builder()
                .roleID(RoleID.of(entity.getUuid()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .dataStatus(entity.getDataStatus())
                .createdDate(GDateTime.of(entity.getCreatedDate()))
                .modificationDate(GDateTime.of(entity.getLastModifiedDate()))
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public RoleEntity toEntity(RoleRoot root) {
        return RoleEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .version(root.getVersionValue())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getRowStatus())
                .name(root.getName())
                .description(root.getDescription())
                .build();
    }

    @Override
    public RoleEntity toNewEntity(RoleRoot root) {
        return RoleEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getRowStatus())
                .name(root.getName())
                .description(root.getDescription())
                .build();
    }
}
