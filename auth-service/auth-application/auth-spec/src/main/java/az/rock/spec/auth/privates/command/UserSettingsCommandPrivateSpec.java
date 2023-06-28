package az.rock.spec.auth.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;
import org.springframework.http.ResponseEntity;

public interface UserSettingsCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> changeLanguage(Language language);

    ResponseEntity<JSuccessResponse> changeDarkMode(Switch switcher);

    ResponseEntity<JSuccessResponse> changeEmailNotification(Switch switcher);

    ResponseEntity<JSuccessResponse> changeSmsNotification(Switch switcher);

    ResponseEntity<JSuccessResponse> changePushNotification(Switch switcher);

    ResponseEntity<JSuccessResponse> changeTwoFactorAuthentication(Switch switcher);

    ResponseEntity<JSuccessResponse> changeVisibleLocation(Switch switcher);

    ResponseEntity<JSuccessResponse> changeVisibleOnlineStatus(Switch switcher);

    ResponseEntity<JSuccessResponse> changeVisibleLastSeen(Switch switcher);

    ResponseEntity<JSuccessResponse> changeVisibleProfilePicture(Switch switcher);
}
