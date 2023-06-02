package az.rock.flyjob.auth.api.rest.privates.command;

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

    @PutMapping("/change-language")
    public ResponseEntity<JSuccessResponse> changeLanguage(@RequestBody Language language) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-active-dark-mode")
    public ResponseEntity<JSuccessResponse> isActiveDarkMode(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-active-email-notification")
    public ResponseEntity<JSuccessResponse> isActiveEmailNotification(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-active-sms-notification")
    public ResponseEntity<JSuccessResponse> isActiveSmsNotification(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-active-push-notification")
    public ResponseEntity<JSuccessResponse> isActivePushNotification(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-active-two-factor-authentication")
    public ResponseEntity<JSuccessResponse> isActiveTwoFactorAuthentication(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-location")
    public ResponseEntity<JSuccessResponse> isVisibleLocation(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-online-status")
    public ResponseEntity<JSuccessResponse> isVisibleOnlineStatus(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-last-seen")
    public ResponseEntity<JSuccessResponse> isVisibleLastSeen(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-profile-picture")
    public ResponseEntity<JSuccessResponse> isVisibleProfilePicture(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-email")
    public ResponseEntity<JSuccessResponse> isVisibleEmail(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @PutMapping("/set-visible-resume")
    public ResponseEntity<JSuccessResponse> isVisibleResume(@RequestBody Switch switcher) {
        return ResponseEntity.ok(new JSuccessResponse());
    }

}
