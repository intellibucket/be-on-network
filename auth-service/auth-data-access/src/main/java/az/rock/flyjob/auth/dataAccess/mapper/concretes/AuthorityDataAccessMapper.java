package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.AuthorityEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractAuthorityDataAccessMapper;
import az.rock.flyjob.auth.root.AuthorityRoot;
import az.rock.lib.domain.id.AuthorityID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AuthorityDataAccessMapper implements AbstractAuthorityDataAccessMapper<AuthorityEntity, AuthorityRoot> {

    @Override
    public AuthorityRoot toRoot(AuthorityEntity entity) {
        return AuthorityRoot.Builder
                .builder()
                .id(AuthorityID.of(entity.getUuid()))
                .createdDate(GDateTime.of(entity.getCreatedDate()))
                .modificationDate(GDateTime.of(entity.getLastModifiedDate()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .dataStatus(entity.getDataStatus())
                .permission(entity.getPermission())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public AuthorityEntity toEntity(AuthorityRoot root) {
        return AuthorityEntity.Builder
                .builder()
                .uuid(root.getUUID().getUUID())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .version(root.getVersion())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .description(root.getDescription())
                .permission(root.getPermission())
                .build();
    }

    @Override
    public AuthorityEntity toNewEntity(AuthorityRoot root) {
        return AuthorityEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .version(root.getVersion())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .description(root.getDescription())
                .permission(root.getPermission())
                .build();
    }
}

