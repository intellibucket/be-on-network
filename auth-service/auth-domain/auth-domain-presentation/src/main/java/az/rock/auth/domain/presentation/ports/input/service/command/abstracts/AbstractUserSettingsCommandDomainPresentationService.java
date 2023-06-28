package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;

public interface AbstractUserSettingsCommandDomainPresentationService {
    void changeLanguage(Language language);

    void changeDarkMode(Switch switcher);

    void changeEmailNotification(Switch switcher);

    void changeSmsNotification(Switch switcher);

    void changePushNotification(Switch switcher);

    void changeTwoFactorAuthentication(Switch switcher);

    void changeVisibleLocation(Switch switcher);

    void changeVisibleOnlineStatus(Switch switcher);

    void changeVisibleLastSeen(Switch switcher);

    void changeVisibleProfilePicture(Switch switcher);

    void changeVisibleEmail(Switch switcher);

    void changeVisibleResume(Switch switcher);
}
