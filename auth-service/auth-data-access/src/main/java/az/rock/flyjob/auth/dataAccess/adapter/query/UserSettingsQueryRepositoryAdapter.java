package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserSettingsQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.entity.user.UserSettingsEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserSettingsDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.query.UserSettingsQueryJPARepository;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.domain.id.UserSettingsID;
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
        var entity = this.userSettingsJPARepository.findByUser(rootId.getUUID());
        return this.userSettingsDataAccessMapper.toRoot(entity);
    }

    @Override
    public Optional<UserSettingsRoot> findByPID(UserID userId) {
        var entity = this.userSettingsJPARepository.findByUser(userId.getUUID());
        return this.userSettingsDataAccessMapper.toRoot(entity);
    }

}
