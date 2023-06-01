package az.rock.spec.auth.privates.query;

import az.rock.auth.domain.presentation.dto.response.UserSettingResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

public interface UserSettingsQueryPrivateControllerSpec {
    ResponseEntity<JSuccessDataResponse<UserSettingResponse>> mySettings();
}
