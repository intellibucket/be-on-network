package az.rock.flyjob.auth.dataAccess.model.compose.user;

import az.rock.flyjob.auth.dataAccess.model.compose.BaseCompose;
import az.rock.lib.valueObject.Language;
import com.intellibucket.lib.fj.dataaccess.annotations.Compose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Compose
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSettingsCompose extends BaseCompose {
    private UUID userUUID;

    private Language language;

    private Boolean isActiveDarkMode;

    private Boolean isActiveEmailNotification;

    private Boolean isActiveSmsNotification;

    private Boolean isActivePushNotification;

    private Boolean isActiveTwoFactorAuthentication;

    private Boolean isVisibleLocation;

    private Boolean isVisibleOnlineStatus;

    private Boolean isVisibleLastSeen;

    private Boolean isVisibleProfilePicture;

    private Boolean isVisibleEmail;

    private Boolean isVisibleResume;
}
