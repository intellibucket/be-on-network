package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractUserSettingsRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.entity.user.UserSettingsEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserSettingsDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.UserSettingsJPARepository;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class UserSettingsRepositoryAdapter implements AbstractUserSettingsRepositoryAdapter {
    private final UserSettingsJPARepository userSettingsJPARepository;
    private final AbstractUserSettingsDataAccessMapper<UserSettingsEntity,UserSettingsRoot> userSettingsDataAccessMapper;

    public UserSettingsRepositoryAdapter(UserSettingsJPARepository userSettingsJPARepository,
                                         AbstractUserSettingsDataAccessMapper<UserSettingsEntity, UserSettingsRoot> userSettingsDataAccessMapper) {
        this.userSettingsJPARepository = userSettingsJPARepository;
        this.userSettingsDataAccessMapper = userSettingsDataAccessMapper;
    }

    @Override
    public UserSettingsRoot create(UserSettingsRoot root) {
        return null;
    }


    @Override
    public UserSettingsRoot findByUserId(UserID userId) {
        var entity = this.userSettingsJPARepository.findByUser(userId.getUUID());
        return this.userSettingsDataAccessMapper.toRoot(entity);
    }
}
