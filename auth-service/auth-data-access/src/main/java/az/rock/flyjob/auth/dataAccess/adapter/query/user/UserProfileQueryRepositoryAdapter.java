package az.rock.flyjob.auth.dataAccess.adapter.query.user;

import az.rock.auth.domain.presentation.dto.response.user.SimpleAnyUserProfileResponse;
import az.rock.auth.domain.presentation.dto.response.user.SimpleFollowerUserResponse;
import az.rock.auth.domain.presentation.dto.response.user.SimpleNetworkUserResponse;
import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserProfileQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.batis.AbstractUserComposeQueryBatisRepository;
import az.rock.flyjob.auth.model.query.AnyProfileQueryRecord;
import az.rock.flyjob.auth.model.query.MyProfileQueryRecord;
import az.rock.lib.valueObject.common.PageableRequest;
import org.springframework.stereotype.Component;

import java.util.List;
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

    @Override
    public List<SimpleAnyUserProfileResponse> findAllAnyProfiles(UUID authenticatedUserId, List<UUID> targetUserIds) {
        if (authenticatedUserId != null && targetUserIds != null && !targetUserIds.isEmpty())
            return this.abstractUserComposeQueryBatisRepository.findAllAnyUserProfilesByIds(authenticatedUserId, targetUserIds);
        return List.of();
    }

    @Override
    public List<SimpleFollowerUserResponse> findAllMyFollowers(UUID authenticatedUserId, PageableRequest request) {
        if (authenticatedUserId != null)
            return this.abstractUserComposeQueryBatisRepository.findAllMyFollowers(authenticatedUserId, request);
        return List.of();
    }

    @Override
    public List<SimpleNetworkUserResponse> findAllMyNetworks(UUID authenticatedUserId, PageableRequest request) {
        if (authenticatedUserId != null)
            return this.abstractUserComposeQueryBatisRepository.findAllMyNetworks(authenticatedUserId, request);
        return List.of();
    }
}
