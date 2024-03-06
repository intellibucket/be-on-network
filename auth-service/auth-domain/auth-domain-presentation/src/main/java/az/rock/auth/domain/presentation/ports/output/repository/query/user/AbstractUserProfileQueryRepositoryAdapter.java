package az.rock.auth.domain.presentation.ports.output.repository.query.user;

import az.rock.auth.domain.presentation.dto.response.user.SimpleAnyUserProfileResponse;
import az.rock.auth.domain.presentation.dto.response.user.SimpleFollowerUserResponse;
import az.rock.auth.domain.presentation.dto.response.user.SimpleNetworkUserResponse;
import az.rock.flyjob.auth.model.query.AnyProfileQueryRecord;
import az.rock.flyjob.auth.model.query.MyProfileQueryRecord;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.valueObject.common.PageableRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
@Transactional(readOnly = true)
public interface AbstractUserProfileQueryRepositoryAdapter {
    Optional<MyProfileQueryRecord> findMyProfile(UUID userID);

    Optional<AnyProfileQueryRecord> findAnyProfile(UUID authenticatedUserId, UUID targetUserId);

    List<SimpleAnyUserProfileResponse> findAllAnyProfiles(UUID authenticatedUserId, List<UUID> targetUserIds);

    List<SimpleFollowerUserResponse> findAllMyFollowers(UUID authenticatedUserId, PageableRequest request);

    List<SimpleNetworkUserResponse> findAllMyNetworks(UUID authenticatedUserId,PageableRequest request);
}
