package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.UserEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.UserRoot;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper implements AbstractDataAccessMapper<UserEntity, UserRoot> {
    @Override
    public UserRoot toRoot(UserEntity entity) {
        return null;
    }

    @Override
    public UserEntity toEntity(UserRoot root) {
        return null;
    }

    @Override
    public UserEntity toNewEntity(UserRoot root) {
        return null;
    }
}

