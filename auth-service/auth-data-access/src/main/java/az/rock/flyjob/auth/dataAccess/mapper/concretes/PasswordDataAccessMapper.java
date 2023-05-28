package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.user.PasswordEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractPasswordDataAccessMapper;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.BaseEntity;
import org.springframework.stereotype.Component;

@Component
public class PasswordDataAccessMapper implements AbstractPasswordDataAccessMapper<PasswordEntity, PasswordRoot> {
    @Override
    public PasswordRoot toRoot(PasswordEntity entity) {
        return PasswordRoot.Builder
                .builder()
                .build();
    }

    @Override
    public PasswordEntity toEntity(PasswordRoot root) {
        return null;
    }

    @Override
    public PasswordEntity toNewEntity(PasswordRoot root) {
        return PasswordEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .version(root.getVersion().value())
                .salt(root.getSalt())
                .hash(root.getHash())
                .build();
    }


}
