package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.model.entity.user.PasswordEntity;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractPasswordDataAccessMapper;
import az.rock.flyjob.auth.model.root.user.PasswordRoot;
import az.rock.lib.domain.id.auth.PasswordID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.util.GDateTime;
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
                        .userID(UserID.of(entity.getUser().getUuid()))
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
                .uuid(root.getRootID().getAbsoluteID())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .version(root.getVersion().value())
                .user(UserEntity.referenceObject(root.getUserID().getAbsoluteID()))
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
                .uuid(root.getRootID().getAbsoluteID())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .version(root.getVersion().value())
                .user(UserEntity.referenceObject(root.getUserID().getAbsoluteID()))
                .salt(root.getSalt())
                .hash(root.getHash())
                .build());
    }


}
