package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.PasswordEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractPasswordDataAccessMapper;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.domain.id.PasswordID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PasswordDataAccessMapper implements AbstractPasswordDataAccessMapper<PasswordEntity, PasswordRoot> {
    @Override
    public Optional<PasswordRoot> toRoot(PasswordEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(PasswordRoot.Builder
                        .builder()
                        .id(PasswordID.of(entity.getUuid()))
                        .version(Version.of(entity.getVersion()))
                        .processStatus(entity.getProcessStatus())
                        .rowStatus(entity.getRowStatus())
                        .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                        .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                        .salt(entity.getSalt())
                        .hash(entity.getHash())
                        .build());
    }

    @Override
    public Optional<PasswordEntity> toEntity(PasswordRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(PasswordEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .version(root.getVersion().value())
                .salt(root.getSalt())
                .hash(root.getHash())
                .build());
    }

    @Override
    public Optional<PasswordEntity> toNewEntity(PasswordRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(PasswordEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .version(root.getVersion().value())
                .salt(root.getSalt())
                .hash(root.getHash())
                .build());
    }


}
