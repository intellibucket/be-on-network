package az.rock.flyjob.auth.dataAccess.adapter.query.user;

import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserProfileQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.batis.AbstractUserComposeQueryBatisRepository;
import az.rock.flyjob.auth.model.query.UserProfileQueryRecord;
import az.rock.lib.annotation.DomainOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserProfileQueryRepositoryAdapter implements AbstractUserProfileQueryRepositoryAdapter {

    private final AbstractUserComposeQueryBatisRepository abstractUserComposeQueryBatisRepository;

    public UserProfileQueryRepositoryAdapter(AbstractUserComposeQueryBatisRepository abstractUserComposeQueryBatisRepository) {
        this.abstractUserComposeQueryBatisRepository = abstractUserComposeQueryBatisRepository;
    }

    public Optional<UserProfileQueryRecord> findMyProfile(UUID userID){
        if (userID != null)
            return Optional.ofNullable(
                    this.abstractUserComposeQueryBatisRepository.findUserProfileById(userID)
            );
        return Optional.empty();
    }
}
