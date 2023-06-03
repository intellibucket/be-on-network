package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserSettingsQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.entity.user.UserSettingsEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserSettingsDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.UserSettingsJPARepository;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.domain.id.UserSettingsID;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSettingsQueryRepositoryAdapter implements AbstractUserSettingsQueryRepositoryAdapter {
    private final UserSettingsJPARepository userSettingsJPARepository;
    private final AbstractUserSettingsDataAccessMapper<UserSettingsEntity,UserSettingsRoot> userSettingsDataAccessMapper;

    public UserSettingsQueryRepositoryAdapter(UserSettingsJPARepository userSettingsJPARepository,
                                              AbstractUserSettingsDataAccessMapper<UserSettingsEntity, UserSettingsRoot> userSettingsDataAccessMapper) {
        this.userSettingsJPARepository = userSettingsJPARepository;
        this.userSettingsDataAccessMapper = userSettingsDataAccessMapper;
    }

    @Override
    public UserSettingsRoot findById(UserSettingsID rootId) {
        return null;
    }

    @Override
    public UserSettingsRoot findByPID(UserID userId) {
        var entity = this.userSettingsJPARepository.findByUser(userId.getUUID());
        return this.userSettingsDataAccessMapper.toRoot(entity);
    }

}
