package az.rock.auth.domain.presentation.dto.response;

import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.lib.valueObject.Language;

public record UserSettingModelResponse(Language language,
                                       Boolean isActiveDarkMode,
                                       Boolean isActiveEmailNotification,
                                       Boolean isActiveSmsNotification,
                                       Boolean isActivePushNotification,
                                       Boolean isActiveTwoFactorAuthentication,
                                       Boolean isVisibleLocation,
                                       Boolean isVisibleOnlineStatus,
                                       Boolean isVisibleLastSeen,
                                       Boolean isVisibleProfilePicture,
                                       Boolean isVisibleEmail,
                                       Boolean isVisibleResume) {
    private UserSettingModelResponse(UserSettingsRoot root){
        this(root.getLanguage(), root.isActiveDarkMode(), root.isActiveEmailNotification(), root.isActiveSmsNotification(),
                root.isActivePushNotification(), root.isActiveTwoFactorAuthentication(), root.isVisibleLocation(),
                root.isVisibleOnlineStatus(), root.isVisibleLastSeen(), root.isVisibleProfilePicture(),
                root.isVisibleEmail(), root.isVisibleResume());
    }

    public static UserSettingModelResponse of(UserSettingsRoot root){
        return new UserSettingModelResponse(root);
    }
}
