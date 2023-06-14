package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.UserMyAccountResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

public interface UserQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<UserMyAccountResponse>> getCurrentUser();
}
