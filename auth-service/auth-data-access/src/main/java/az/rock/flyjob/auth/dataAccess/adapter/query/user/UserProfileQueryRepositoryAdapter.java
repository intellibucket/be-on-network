package az.rock.flyjob.auth.dataAccess.adapter.query.user;

import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserProfileQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.batis.AbstractUserComposeQueryBatisRepository;
import az.rock.flyjob.auth.model.query.AnyProfileQueryRecord;
import az.rock.flyjob.auth.model.query.MyProfileQueryRecord;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserProfileQueryRepositoryAdapter implements AbstractUserProfileQueryRepositoryAdapter {

    private final AbstractUserComposeQueryBatisRepository abstractUserComposeQueryBatisRepository;

    public UserProfileQueryRepositoryAdapter(AbstractUserComposeQueryBatisRepository abstractUserComposeQueryBatisRepository) {
        this.abstractUserComposeQueryBatisRepository = abstractUserComposeQueryBatisRepository;
    }

    public Optional<MyProfileQueryRecord> findMyProfile(UUID userID){
        if (userID != null)
            return Optional.ofNullable(
                    this.abstractUserComposeQueryBatisRepository.findUserProfileById(userID)
            );
        return Optional.empty();
    }

    @Override
    public Optional<AnyProfileQueryRecord> findAnyProfile(UUID authenticatedUserId, UUID targetUserId) {
        if (authenticatedUserId != null && targetUserId != null)
            return Optional.ofNullable(
                    this.abstractUserComposeQueryBatisRepository.findAnyUserProfileById(authenticatedUserId, targetUserId)
            );
        return Optional.empty();
    }
}
