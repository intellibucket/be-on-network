package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.dto.response.UserSettingModelResponse;
import az.rock.auth.domain.presentation.service.query.abstracts.AbstractUserSettingsQueryDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.UserSettingsQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/settings" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class UserSettingsQueryPrivateController implements UserSettingsQueryPrivateSpec {
    private final AbstractUserSettingsQueryDomainPresentationService userSettingsQueryDomainPresentationService;

    public UserSettingsQueryPrivateController(AbstractUserSettingsQueryDomainPresentationService userSettingsQueryDomainPresentationService) {
        this.userSettingsQueryDomainPresentationService = userSettingsQueryDomainPresentationService;
    }

    @GetMapping("/my-settings")
    public ResponseEntity<JSuccessDataResponse<UserSettingModelResponse>> mySettings() {
        var response = this.userSettingsQueryDomainPresentationService.currentUserSettings();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

}
