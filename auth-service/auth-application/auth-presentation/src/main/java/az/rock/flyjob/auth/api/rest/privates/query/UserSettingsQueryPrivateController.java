package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.dto.response.UserSettingResponse;
import az.rock.auth.domain.presentation.service.query.abstracts.AbstractUserSettingsQueryDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/1.0/private/settings")
public class UserSettingsQueryPrivateController {
    private final AbstractUserSettingsQueryDomainPresentationService userSettingsQueryDomainPresentationService;

    public UserSettingsQueryPrivateController(AbstractUserSettingsQueryDomainPresentationService userSettingsQueryDomainPresentationService) {
        this.userSettingsQueryDomainPresentationService = userSettingsQueryDomainPresentationService;
    }

    @GetMapping("/my-settings")
    public ResponseEntity<JSuccessDataResponse<UserSettingResponse>> mySettings() {
        var response = this.userSettingsQueryDomainPresentationService.getUserSettings();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

}
