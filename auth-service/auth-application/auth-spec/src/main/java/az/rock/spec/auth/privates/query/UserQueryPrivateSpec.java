package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.UserAnyAccountResponse;
import az.rock.auth.domain.presentation.dto.response.UserMyAccountResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<UserMyAccountResponse>> getCurrentUser();

    ResponseEntity<JSuccessDataResponse<UserAnyAccountResponse>> getUser(UUID userId);

    ResponseEntity<JSuccessDataResponse<List<UserAnyAccountResponse>>> getUserList(List<UUID> users);
}
