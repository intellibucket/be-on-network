package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserSettingsCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.entity.user.settings.UserSettingsEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserSettingsDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.user.AbstractUserSettingsCommandCustomJPARepository;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserSettingsCommandRepositoryAdapter implements AbstractUserSettingsCommandRepositoryAdapter {
    private final AbstractUserSettingsDataAccessMapper<UserSettingsEntity,UserSettingsRoot> userSettingsDataAccessMapper;
    private final AbstractUserSettingsCommandCustomJPARepository userSettingsCommandCustomJPARepository;

    public UserSettingsCommandRepositoryAdapter(AbstractUserSettingsDataAccessMapper<UserSettingsEntity,UserSettingsRoot> userSettingsDataAccessMapper,
                                                AbstractUserSettingsCommandCustomJPARepository userSettingsCommandCustomJPARepository) {
        this.userSettingsDataAccessMapper = userSettingsDataAccessMapper;
        this.userSettingsCommandCustomJPARepository = userSettingsCommandCustomJPARepository;
    }

    @Override
    public Optional<UserSettingsRoot> create(UserSettingsRoot root) {
        var entity = this.userSettingsDataAccessMapper.toNewEntity(root);
        if (entity.isPresent()) {
            var savedEntity = this.userSettingsCommandCustomJPARepository.persist(entity.get());
            return this.userSettingsDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void update(UserSettingsRoot root) {
        var entity = this.userSettingsDataAccessMapper.toEntity(root);
        entity.ifPresent(this.userSettingsCommandCustomJPARepository::update);
    }
}
