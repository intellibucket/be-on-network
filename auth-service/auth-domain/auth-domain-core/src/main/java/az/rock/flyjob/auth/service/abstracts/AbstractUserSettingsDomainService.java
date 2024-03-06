package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.model.root.user.UserSettingsRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;

public interface AbstractUserSettingsDomainService {
    UserSettingsRoot validateAmdChangeLanguage(UserID userID, UserSettingsRoot userSettingsRoot, Language language);

    UserSettingsRoot validateAndChangeDarkMode(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

    UserSettingsRoot validateAndChangeEmailNotification(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

    UserSettingsRoot validateAndChangeSmsNotification(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

    UserSettingsRoot validateAndChangePushNotification(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

    UserSettingsRoot validateAndChangeTwoFactorAuthentication(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

    UserSettingsRoot validateAndChangeVisibleLocation(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

    UserSettingsRoot validateAndChangeVisibleOnlineStatus(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

    UserSettingsRoot validateAndChangeVisibleLastSeen(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

    UserSettingsRoot validateAndChangeVisibleProfilePicture(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

    UserSettingsRoot validateAndChangeVisibleEmail(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

    UserSettingsRoot validateAndChangeVisibleResume(UserID currentUserID, UserSettingsRoot entity, Switch switcher);

}
