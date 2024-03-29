package az.rock.flyjob.auth.dataAccess.adapter.query.user;

import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.data.UserQueryJPARepository;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.UserIdTypePair;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserQueryRepositoryAdapter implements AbstractUserQueryRepositoryAdapter {
    private final UserQueryJPARepository userQueryJPARepository;
    private final AbstractUserDataAccessMapper<UserEntity,UserRoot> abstractUserDataAccessMapper;

    public UserQueryRepositoryAdapter(UserQueryJPARepository userQueryJPARepository,
                                      AbstractUserDataAccessMapper<UserEntity, UserRoot> abstractUserDataAccessMapper) {
        this.userQueryJPARepository = userQueryJPARepository;
        this.abstractUserDataAccessMapper = abstractUserDataAccessMapper;
    }

    @Override
    public Optional<UserRoot> findById(UserID currentUser) {
        var optionalRoot = this.userQueryJPARepository
                .findById(currentUser.getAbsoluteID());
        if (optionalRoot.isPresent()) {
            var userEntity = optionalRoot.get();
            return this.abstractUserDataAccessMapper.toRoot(userEntity);
        } else return Optional.empty();
    }

    @Override
    public Optional<UserRoot> fetchById(UserID currentUser) {
        return AbstractUserQueryRepositoryAdapter.super.fetchById(currentUser);
    }

    @Override
    public Boolean isExistByUsername(String username) {
        return this.userQueryJPARepository.existsByUsername(username);
    }

    @Override
    public UserIdTypePair findUserTypeById(UserID userID) {
        var userType = this.userQueryJPARepository.findUserTypeById(userID.getAbsoluteID());
        return new UserIdTypePair(userID, userType);
    }
}
