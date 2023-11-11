package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.UserAnyAccountResponse;
import az.rock.auth.domain.presentation.dto.response.user.MyUserProfileResponse;
import az.rock.auth.domain.presentation.dto.response.user.SimpleFollowerUserResponse;
import az.rock.auth.domain.presentation.dto.response.user.SimpleNetworkUserResponse;
import az.rock.auth.domain.presentation.dto.response.user.UserMyAccountResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageable;
import az.rock.lib.valueObject.common.PageableRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<MyUserProfileResponse>> getMyProfile();

    ResponseEntity<JSuccessDataResponse<UserAnyAccountResponse>> getUser(UUID userId);

    ResponseEntity<JSuccessDataResponse<List<UserAnyAccountResponse>>> getUserList(List<UUID> users);

    ResponseEntity<JSuccessDataResponse<SimplePageable<List<SimpleFollowerUserResponse>>>> getMyFollowerItems(PageableRequest request);

    ResponseEntity<JSuccessDataResponse<SimplePageable<List<SimpleNetworkUserResponse>>>> getMyNetworkItems(PageableRequest request);
}
