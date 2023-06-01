package az.rock.spec.auth.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;
import org.springframework.http.ResponseEntity;

public interface UserSettingsCommandPrivateControllerSpec {
    ResponseEntity<JSuccessResponse> language(Language language);

    ResponseEntity<JSuccessResponse> isActiveDarkMode(Switch switcher);

    ResponseEntity<JSuccessResponse> isActiveEmailNotification(Switch switcher);

    ResponseEntity<JSuccessResponse> isActiveSmsNotification(Switch switcher);

    ResponseEntity<JSuccessResponse> isActivePushNotification(Switch switcher);

    ResponseEntity<JSuccessResponse> isActiveTwoFactorAuthentication(Switch switcher);

    ResponseEntity<JSuccessResponse> isVisibleLocation(Switch switcher);

    ResponseEntity<JSuccessResponse> isVisibleOnlineStatus(Switch switcher);

    ResponseEntity<JSuccessResponse> isVisibleLastSeen(Switch switcher);

    ResponseEntity<JSuccessResponse> isVisibleProfilePicture(Switch switcher);
}
