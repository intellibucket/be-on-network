package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.user.*;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageable;
import az.rock.lib.valueObject.common.PageableRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<MyUserProfileResponse>> getMyProfile();

    ResponseEntity<JSuccessDataResponse<AnyUserProfileResponse>> getAnyProfile(UUID userId);

    ResponseEntity<JSuccessDataResponse<List<SimpleAnyUserProfileResponse>>> getUserList(List<UUID> users);

    ResponseEntity<JSuccessDataResponse<SimplePageable<List<SimpleFollowerUserResponse>>>> getMyFollowerItems(PageableRequest request);

    ResponseEntity<JSuccessDataResponse<SimplePageable<List<SimpleNetworkUserResponse>>>> getMyNetworkItems(PageableRequest request);
}
