package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.settings.IllegalLanguageException;
import az.rock.flyjob.auth.root.user.UserSettingsRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractUserSettingsDomainService;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;

public class UserSettingsDomainService implements AbstractUserSettingsDomainService {
    @Override
    public UserSettingsRoot validateAmdChangeLanguage(UserID userID, UserSettingsRoot userSettingsRoot, Language language) {
        if (language.isUnknown()) throw new IllegalLanguageException();
        if (userSettingsRoot.getLanguage().equals(language)) return userSettingsRoot;
        return userSettingsRoot.changeLanguage(language);
    }

    @Override
    public UserSettingsRoot validateAndChangeDarkMode(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changeDarkMode(switcher.isOn());
    }

    @Override
    public UserSettingsRoot validateAndChangeEmailNotification(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changeEmailNotification(switcher.isOn());
    }

    @Override
    public UserSettingsRoot validateAndChangeSmsNotification(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changeSmsNotification(switcher.isOn());
    }

    @Override
    public UserSettingsRoot validateAndChangePushNotification(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changePushNotification(switcher.isOn());
    }

    @Override
    public UserSettingsRoot validateAndChangeTwoFactorAuthentication(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changeTwoFactorAuthentication(switcher.isOn());
    }

    @Override
    public UserSettingsRoot validateAndChangeVisibleLocation(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changeLocationVisibility(switcher.isOn());
    }

    @Override
    public UserSettingsRoot validateAndChangeVisibleOnlineStatus(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changeOnlineStatusVisibility(switcher.isOn());
    }

    @Override
    public UserSettingsRoot validateAndChangeVisibleLastSeen(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changeLastSeenVisibility(switcher.isOn());
    }

    @Override
    public UserSettingsRoot validateAndChangeVisibleProfilePicture(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changeProfilePictureVisibility(switcher.isOn());
    }

    @Override
    public UserSettingsRoot validateAndChangeVisibleEmail(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changeEmailVisibility(switcher.isOn());
    }

    @Override
    public UserSettingsRoot validateAndChangeVisibleResume(UserID currentUserID, UserSettingsRoot root, Switch switcher) {
        return root.changeResumeVisibility(switcher.isOn());
    }

}
