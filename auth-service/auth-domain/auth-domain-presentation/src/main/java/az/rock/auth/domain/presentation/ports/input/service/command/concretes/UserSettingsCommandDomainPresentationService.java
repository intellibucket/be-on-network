package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserSettingsUpdateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractUserSettingsCommandDomainPresentationService;
import az.rock.flyjob.auth.event.user.UserSettingsUpdatedEvent;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Switch;
import org.springframework.stereotype.Service;

@Service
public class UserSettingsCommandDomainPresentationService implements AbstractUserSettingsCommandDomainPresentationService {

    private final AbstractUserSettingsUpdateCommandHandler userSettingsUpdateCommandHandler;

    public UserSettingsCommandDomainPresentationService(AbstractUserSettingsUpdateCommandHandler userSettingsUpdateCommandHandler) {
        this.userSettingsUpdateCommandHandler = userSettingsUpdateCommandHandler;
    }

    @Override
    public void changeLanguage(Language language) {
        UserSettingsUpdatedEvent event = this.userSettingsUpdateCommandHandler.handleLanguageChange(language);
    }

    @Override
    public void changeDarkMode(Switch switcher) {

    }

    @Override
    public void changeEmailNotification(Switch switcher) {

    }

    @Override
    public void changeSmsNotification(Switch switcher) {

    }

    @Override
    public void changePushNotification(Switch switcher) {

    }

    @Override
    public void changeTwoFactorAuthentication(Switch switcher) {

    }

    @Override
    public void changeVisibleLocation(Switch switcher) {

    }

    @Override
    public void changeVisibleOnlineStatus(Switch switcher) {

    }

    @Override
    public void changeVisibleLastSeen(Switch switcher) {

    }

    @Override
    public void changeVisibleProfilePicture(Switch switcher) {

    }

    @Override
    public void changeVisibleEmail(Switch switcher) {

    }

    @Override
    public void changeVisibleResume(Switch switcher) {

    }
}
