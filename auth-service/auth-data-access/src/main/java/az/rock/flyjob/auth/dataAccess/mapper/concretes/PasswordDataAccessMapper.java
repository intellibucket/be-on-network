package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.PasswordEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.PasswordRoot;
import org.springframework.stereotype.Component;

@Component
public class PasswordDataAccessMapper implements AbstractDataAccessMapper<PasswordEntity, PasswordRoot> {
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
        return null;
    }
}
