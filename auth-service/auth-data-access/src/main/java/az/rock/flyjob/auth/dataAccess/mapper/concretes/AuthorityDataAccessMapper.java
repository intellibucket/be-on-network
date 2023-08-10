package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.model.entity.security.AuthorityEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractAuthorityDataAccessMapper;
import az.rock.flyjob.auth.root.security.AuthorityRoot;
import az.rock.lib.domain.id.AuthorityID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AuthorityDataAccessMapper implements AbstractAuthorityDataAccessMapper<AuthorityEntity, AuthorityRoot> {

    @Override
    public Optional<AuthorityRoot> toRoot(AuthorityEntity entity) {
        var optionalAuthorityEntity = Optional.ofNullable(entity);
        if (optionalAuthorityEntity.isEmpty()) return Optional.empty();
        return Optional.of(AuthorityRoot.Builder
                .builder()
                .id(AuthorityID.of(entity.getUuid()))
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .dataStatus(entity.getRowStatus())
                .permission(entity.getPermission())
                .description(entity.getDescription())
                .build());
    }

    @Override
    public Optional<AuthorityEntity> toEntity(AuthorityRoot root) {
        var optionalAuthorityRoot = Optional.ofNullable(root);
        if (optionalAuthorityRoot.isEmpty()) return Optional.empty();
        return Optional.of(AuthorityEntity.Builder
                .builder()
                .uuid(root.getRootID().getRootID())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getRowStatus())
                .description(root.getDescription())
                .permission(root.getPermission())
                .build());
    }

    @Override
    public Optional<AuthorityEntity> toNewEntity(AuthorityRoot root) {
        var optionalAuthorityRoot = Optional.ofNullable(root);
        if (optionalAuthorityRoot.isEmpty()) return Optional.empty();
        return Optional.of(AuthorityEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getRowStatus())
                .description(root.getDescription())
                .permission(root.getPermission())
                .build());
    }
}

