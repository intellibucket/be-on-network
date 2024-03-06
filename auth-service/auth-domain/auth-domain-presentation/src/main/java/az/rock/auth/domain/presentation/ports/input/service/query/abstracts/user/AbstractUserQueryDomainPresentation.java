package az.rock.auth.domain.presentation.ports.input.service.query.abstracts.user;

import az.rock.auth.domain.presentation.dto.response.user.*;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.common.PageableRequest;

import java.util.List;
import java.util.UUID;

@InputPort
public interface AbstractUserQueryDomainPresentation {
    MyUserProfileResponse myProfile();

    AnyUserProfileResponse anyProfile(UUID userID);

    List<SimpleAnyUserProfileResponse> anyProfiles(List<UUID> userIDs);

    List<SimpleFollowerUserResponse> myFollowerItems(PageableRequest request);

    List<SimpleNetworkUserResponse> myNetworkItems(PageableRequest request);
}
