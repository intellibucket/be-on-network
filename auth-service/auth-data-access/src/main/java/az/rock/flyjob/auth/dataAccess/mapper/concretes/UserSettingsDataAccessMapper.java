package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.UserSettingsEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.UserSettingsRoot;
import org.springframework.stereotype.Component;

@Component
public class UserSettingsDataAccessMapper implements AbstractDataAccessMapper<UserSettingsEntity, UserSettingsRoot> {
    @Override
    public UserSettingsRoot toRoot(UserSettingsEntity entity) {
        return null;
    }

    @Override
    public UserSettingsEntity toEntity(UserSettingsRoot root) {
        return null;
    }

    @Override
    public UserSettingsEntity toNewEntity(UserSettingsRoot root) {
        return null;
    }
}
