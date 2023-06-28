package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractUserSettingsCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;
import az.rock.spec.auth.privates.command.UserSettingsCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/settings",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserSettingsCommandPrivateController implements UserSettingsCommandPrivateSpec {

    private final AbstractUserSettingsCommandDomainPresentationService userSettingsCommandDomainPresentationService;

    public UserSettingsCommandPrivateController(AbstractUserSettingsCommandDomainPresentationService userSettingsCommandDomainPresentationService) {
        this.userSettingsCommandDomainPresentationService = userSettingsCommandDomainPresentationService;
    }


    @PutMapping("/change-language")
    public ResponseEntity<JSuccessResponse> changeLanguage(@RequestBody Language language) {
        this.userSettingsCommandDomainPresentationService.changeLanguage(language);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-active-dark-mode")
    public ResponseEntity<JSuccessResponse> changeDarkMode(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changeDarkMode(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-active-email-notification")
    public ResponseEntity<JSuccessResponse> changeEmailNotification(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changeEmailNotification(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-active-sms-notification")
    public ResponseEntity<JSuccessResponse> changeSmsNotification(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changeSmsNotification(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-active-push-notification")
    public ResponseEntity<JSuccessResponse> changePushNotification(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changePushNotification(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-active-two-factor-authentication")
    public ResponseEntity<JSuccessResponse> changeTwoFactorAuthentication(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changeTwoFactorAuthentication(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-location")
    public ResponseEntity<JSuccessResponse> changeVisibleLocation(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changeVisibleLocation(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-online-status")
    public ResponseEntity<JSuccessResponse> changeVisibleOnlineStatus(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changeVisibleOnlineStatus(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-last-seen")
    public ResponseEntity<JSuccessResponse> changeVisibleLastSeen(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changeVisibleLastSeen(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-profile-picture")
    public ResponseEntity<JSuccessResponse> changeVisibleProfilePicture(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changeVisibleProfilePicture(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-email")
    public ResponseEntity<JSuccessResponse> changeVisibleEmail(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changeVisibleEmail(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-resume")
    public ResponseEntity<JSuccessResponse> changeVisibleResume(@RequestBody Switch switcher) {
        this.userSettingsCommandDomainPresentationService.changeVisibleResume(switcher);
        return ResponseEntity.ok(new JSuccessResponse());
    }

}
