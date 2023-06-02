package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.UserModelResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

public interface UserQueryPrivateControllerSpec {
    ResponseEntity<JSuccessDataResponse<UserModelResponse>> getCurrentUser();
}
