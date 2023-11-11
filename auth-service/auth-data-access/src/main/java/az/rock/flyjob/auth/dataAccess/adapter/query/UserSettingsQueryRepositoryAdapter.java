package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserSettingsQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.entity.user.settings.UserSettingsEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserSettingsDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.data.UserSettingsQueryJPARepository;
import az.rock.flyjob.auth.model.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.auth.UserSettingsID;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserSettingsQueryRepositoryAdapter implements AbstractUserSettingsQueryRepositoryAdapter {
    private final UserSettingsQueryJPARepository userSettingsJPARepository;
    private final AbstractUserSettingsDataAccessMapper<UserSettingsEntity,UserSettingsRoot> userSettingsDataAccessMapper;

    public UserSettingsQueryRepositoryAdapter(UserSettingsQueryJPARepository userSettingsJPARepository,
                                              AbstractUserSettingsDataAccessMapper<UserSettingsEntity, UserSettingsRoot> userSettingsDataAccessMapper) {
        this.userSettingsJPARepository = userSettingsJPARepository;
        this.userSettingsDataAccessMapper = userSettingsDataAccessMapper;
    }

    @Override
    public Optional<UserSettingsRoot> findById(UserSettingsID rootId) {
        var entity = this.userSettingsJPARepository.findByUser(rootId.getRootID());
        return this.userSettingsDataAccessMapper.toRoot(entity);
    }

    @Override
    public Optional<UserSettingsRoot> findByPID(UserID userId) {
        var entity = this.userSettingsJPARepository.findByUser(userId.getRootID());
        return this.userSettingsDataAccessMapper.toRoot(entity);
    }

}
